package br.com.forum.config;

import static org.springdoc.core.SpringDocUtils.getConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class SpringConfig implements WebMvcConfigurer {

	static {
		getConfig().replaceWithClass(org.springframework.data.domain.Pageable.class, Pageable.class)
				.replaceWithClass(org.springframework.data.domain.PageRequest.class, Pageable.class);
	}

//	@Bean
//	public ObjectMapper objectMapperBuilder() {
		ObjectMapper builder = new ObjectMapper();
//		builder.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//		builder.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//		builder.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//		builder.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		return builder;
//	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer
		.useRegisteredExtensionsOnly(Boolean.TRUE)
		.defaultContentType(MediaType.APPLICATION_JSON);
	}
}
