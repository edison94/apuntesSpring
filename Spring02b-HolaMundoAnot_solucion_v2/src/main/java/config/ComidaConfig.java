package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import service.ComidaImp;
import service.IComida;
 
//Le indicamos que es un fichero de configuración
@Configuration
public class ComidaConfig {
	
    @Bean(name="ENDOCRINO")
    //En Spring 4 existe una anotacion llamada @Description
    public IComida dameComida() {
        return new ComidaImp();
    }

}

