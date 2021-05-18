package br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.globalinformation;

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
public class AllCoinsInformation implements Serializable {
    private Long coins_num;
    private Long time;
}
