package br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coinmarket;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Market {
    private String name;
    private String base;
    private String quote;
    private BigDecimal price;
    private BigDecimal price_usd;
    private BigDecimal volume;
    private BigDecimal volume_usd;
    private Long time;
}
