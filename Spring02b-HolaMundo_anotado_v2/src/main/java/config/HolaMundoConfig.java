package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.HolaMundoImp;
import service.iHolaMundo;
 
@Configuration
public class HolaMundoConfig {
	
	// Fijate que en esta version declaro aquí los beans
    @Bean(name="HOLAMUNDO")
    //En Spring 4 existe una anotacion llamada @Description
    public iHolaMundo helloWorld() {
        return new HolaMundoImp();
    }

}

