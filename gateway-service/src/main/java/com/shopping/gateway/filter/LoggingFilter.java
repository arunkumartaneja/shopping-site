package com.shopping.gateway.filter;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class LoggingFilter implements Filter, Ordered {

	private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        logger.info("Request received for path: {}", exchange.getRequest().getPath());
//
//        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
//            logger.info("Response sent for path: {}", exchange.getRequest().getPath());
//        }));
//    }

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (request instanceof HttpServletRequest) {
			String url = ((HttpServletRequest) request).getRequestURI();
			String queryString = ((HttpServletRequest) request).getQueryString();
			logger.info("Before Request received for path {}", url + "?" + queryString);
		}

		chain.doFilter(request, response);

//		logger.info("After Request received for path: {}");

	}

}
