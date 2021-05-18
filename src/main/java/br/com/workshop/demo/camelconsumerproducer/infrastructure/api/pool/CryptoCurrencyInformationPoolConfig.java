package br.com.workshop.demo.camelconsumerproducer.infrastructure.api.pool;

import feign.Client;
import feign.Request;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class CryptoCurrencyInformationPoolConfig {

    @Value("${pool.cryptocurrency-information-api.maxConn}")
    private Integer connPerRoute;

    @Value("${pool.cryptocurrency-information-api.maxRoutes}")
    private Integer maxConnTotal;

    @Value("${pool.cryptocurrency-information-api.connTimeout}")
    private Integer connTimeout;

    @Value("${pool.cryptocurrency-information-api.readTimeout}")
    private Integer readTimeout;

    @Value("${pool.cryptocurrency-information-api.followRedirects:true}")
    private Boolean followRedirects;

    @Bean
    public Request.Options options() {
        return new Request.Options(connTimeout, MILLISECONDS, readTimeout, MILLISECONDS, followRedirects);
    }

    @Bean
    public Client poolConfig() {
        return new ApacheHttpClient(
                HttpClientBuilder.create()
                        .setMaxConnPerRoute(connPerRoute)
                        .setMaxConnTotal(maxConnTotal)
                        .build()
        );
    }
}
