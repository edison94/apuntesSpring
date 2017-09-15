package spring.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//Indico la carpeta donde se encuentra
@ComponentScan(basePackages = "spring")
public class AppConfig {

}
