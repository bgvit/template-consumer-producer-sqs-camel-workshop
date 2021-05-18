package br.com.workshop.demo.camelconsumerproducer.application.controller;

import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coin.CoinSocialStats;
import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coinmarket.Market;
import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.globalinformation.AllCoins;
import br.com.workshop.demo.camelconsumerproducer.domain.service.TickerService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("ticker")
public class TickerController {

    private final TickerService tickerService;

    @GetMapping("coins")
    public ResponseEntity<AllCoins> findAllCoins() {
        return tickerService.findAllCoins();
    }

    @GetMapping("markets")
    public ResponseEntity<List<Market>> findMarketsByCoinId(@RequestParam String id) {
        return tickerService.findMarketsByCoinId(id);

    }

    @GetMapping("social-stats")
    public ResponseEntity<CoinSocialStats> getSocialStatsByCoinId(@RequestParam String id) {
        return tickerService.findSocialStatsByCoinId(id);

    }
}
