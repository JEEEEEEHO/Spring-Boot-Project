package com.oracle.oBootS20220603.configuration.jh;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.oracle.oBootS20220603.service.jh.JhSampleInterceptorU;

@Configuration
public class JhPaymentDetailConfigurationU implements WebMvcConfigurer {
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new JhSampleInterceptorU()).addPathPatterns("/jhInterCeptor");

	}
}
