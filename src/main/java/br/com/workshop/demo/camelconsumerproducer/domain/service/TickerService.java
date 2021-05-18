package br.com.workshop.demo.camelconsumerproducer.domain.service;

import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coin.CoinSocialStats;
import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coinmarket.Market;
import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.globalinformation.AllCoins;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TickerService {
    ResponseEntity<AllCoins> findAllCoins();

    ResponseEntity<List<Market>> findMarketsByCoinId(String id);

    ResponseEntity<CoinSocialStats> findSocialStatsByCoinId(String id);
}
