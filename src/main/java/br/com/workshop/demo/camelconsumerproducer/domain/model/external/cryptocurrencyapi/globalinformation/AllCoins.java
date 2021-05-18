package br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.globalinformation;

import br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coin.Ticker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AllCoins implements Serializable {
    private List<Ticker> data;
    private AllCoinsInformation info;
}
