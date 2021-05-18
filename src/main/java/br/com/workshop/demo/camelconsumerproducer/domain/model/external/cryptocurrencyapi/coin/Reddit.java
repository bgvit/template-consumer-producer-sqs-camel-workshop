package br.com.workshop.demo.camelconsumerproducer.domain.model.external.cryptocurrencyapi.coin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Reddit {
    private Long avg_active_users;
    private Long subscribers;
}
