package br.com.clientes.configuration;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class WebConfig {

	
	@Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {

		List<String> origins = Arrays.asList("*");
		List<String> methods = Arrays.asList("POST", "OPTIONS", "GET", "DELETE", "PUT");
		List<String> headers = Arrays.asList("X-Requested-With", "Origin", "Content-Type", "Accept", "Authorization");
		
        CorsConfiguration config = new CorsConfiguration();
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        config.setAllowCredentials(true);
        config.setAllowedOrigins(origins);
        config.setAllowedMethods(methods);
        config.setAllowedHeaders(headers);
        
		source.registerCorsConfiguration("/**", config);
		CorsFilter corsFilter = new CorsFilter(source);

		FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(corsFilter);
		filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return filter;
	}
	
	
}
