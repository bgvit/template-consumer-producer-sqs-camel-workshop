package br.com.workshop.demo.camelconsumerproducer.infrastructure.api;

import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coin.CoinSocialStats;
import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coinmarket.Market;
import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.globalinformation.AllCoins;
import br.com.workshop.demo.camelconsumerproducer.infrastructure.api.pool.CryptoCurrencyInformationPoolConfig;
import br.com.workshop.demo.camelconsumerproducer.infrastructure.exception.CryptoCurrencyInformationException;
import br.com.workshop.demo.camelconsumerproducer.infrastructure.exception.IntegrationException;
import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cryptocurrency-information-api", url = "${application.cryptocurrency-information-api.url}", configuration = {
        CryptoCurrencyInformationAPI.CryptoCurrencyDecoder.class, CryptoCurrencyInformationPoolConfig.class
})
public interface CryptoCurrencyInformationAPI {

    @GetMapping("tickers/")
    ResponseEntity<AllCoins> getAllCoins();

    @RequestMapping("coin/markets/")
    ResponseEntity<List<Market>> getMarketsByCoinId(@RequestParam String id);

    @RequestMapping("coin/social_stats/")
    ResponseEntity<CoinSocialStats> getSocialStatsByCoinId(@RequestParam String id);

    class CryptoCurrencyDecoder implements ErrorDecoder {

        @Override
        public IntegrationException decode(String methodKey, Response response) {

            final HttpStatus statusCode = HttpStatus.valueOf(response.status());

            final String message = String.format("Integration fault with cryptocurrencyAPI : method: %s, httpStatus: %d",
                    methodKey, statusCode.value());

            final String detailMessage = FeignException.errorStatus(methodKey, response).getMessage();

            throw new CryptoCurrencyInformationException(message, detailMessage, statusCode);
        }
    }
}
