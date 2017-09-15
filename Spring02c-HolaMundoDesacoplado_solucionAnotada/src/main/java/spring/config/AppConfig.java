package spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// La sg linea hace que autodetecte los beans anotados escaneando el paquete indicado
//    conectandolo cuando se necesite (usando @Resource o @Autowired)
// Le estoy indicando donde se encuentra la ruta con los elementos (el nombre del paquete)
// En este caso le indicamos que el contenido se encuentra en el paquete   spring
// Aparece en la versión 3.1
@ComponentScan("spring")
//Lo indicado es análogo a usar en un XML la siguiente linea
//  <context:component-scan base-package="service" />
public class AppConfig {

}
