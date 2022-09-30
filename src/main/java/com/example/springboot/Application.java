package com.example.springboot;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;

@SpringBootApplication
public class Application {

	@Autowired
	private ServerProperties serverProperties;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// @Bean
	// @Description("Spring Message Resolver")
	// public ResourceBundleMessageSource messageSource() {
	// ResourceBundleMessageSource messageSource = new
	// ResourceBundleMessageSource();
	// messageSource.setBasename("messages");
	// return messageSource;
	// }

	// @Bean
	// @Description("Thymeleaf Template Resolver")
	// public ServletContextTemplateResolver templateResolver() {
	// ServletContextTemplateResolver templateResolver = new
	// ServletContextTemplateResolver(null);
	// templateResolver.setPrefix("/WEB-INF/views/");
	// templateResolver.setSuffix(".html");
	// templateResolver.setTemplateMode("HTML5");

	// return templateResolver;
	// }

	// @Bean
	// @Description("Thymeleaf Template Engine")
	// public SpringTemplateEngine templateEngine() {
	// SpringTemplateEngine templateEngine = new SpringTemplateEngine();
	// templateEngine.setTemplateResolver(templateResolver());
	// templateEngine.setTemplateEngineMessageSource(messageSource());
	// return templateEngine;
	// }

	// @Bean
	// @Description("Thymeleaf View Resolver")
	// public ThymeleafViewResolver viewResolver() {
	// ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
	// viewResolver.setTemplateEngine(templateEngine());
	// viewResolver.setOrder(1);
	// return viewResolver;
	// }

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			// String[] beanNames = ctx.getBeanDefinitionNames();
			// Arrays.sort(beanNames);
			// for (String beanName : beanNames) {
			// System.out.println(beanName);
			// }
			System.out.println("");
			String inetAddress;

			System.out.println("The server address: "
					+ (serverProperties.getAddress() == null ? "localhost(127.0.0.1)" : serverProperties.getAddress())
					+ " && Running on port: " + serverProperties.getPort());

			System.out.println("");
		};
	}

}