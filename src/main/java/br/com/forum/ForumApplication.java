package br.com.forum;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.forum.config.Constants;

@EnableJpaRepositories(Constants.PACKAGE + ".repository") 
@EntityScan(basePackages = Constants.PACKAGE+ ".entity")
@ComponentScan(Constants.PACKAGE)
@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		final SpringApplication application = new SpringApplication(ForumApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.setWebApplicationType(WebApplicationType.SERVLET);
		application.run();
	}

}
