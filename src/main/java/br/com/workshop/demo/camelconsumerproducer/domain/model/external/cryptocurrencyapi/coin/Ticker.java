package br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ticker implements Serializable {

    private String id;
    private String symbol;
    private String name;
    private String nameid;
    private Long rank;
    private String price_usd;
    private String percent_change_24h;
    private String percent_change_1h;
    private String percent_change_7d;
    private String market_cap_usd;
    private String volume24;
    private String volume24a;
    private String csupply;
    private String price_btc;
    private String tsupply;
    private String msupply;

}
