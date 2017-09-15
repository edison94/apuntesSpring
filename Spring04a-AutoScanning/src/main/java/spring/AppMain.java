package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import spring.configuration.AppConfig;
import spring.model.Empleado;
import spring.service.IEmpleadoService;

public class AppMain {

	public static void main(String args[]){
		//Le indico donde se encuentra la configuración
		AbstractApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// Si quieres que no se emplee configuración mediante una clase, puedes incluir estas tres lineas en vez de la anterior
        // AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
        // context.scan("spring"); 
        // context.refresh();

		
		IEmpleadoService service = (IEmpleadoService) context.getBean("employeeService");

		/*
		 * REgistramos el nuevo empleado
		 */
		Empleado employee = new Empleado();
		employee.setName("Antonio Santos");
		service.registerEmployee(employee);
		
		context.close();
	}
}
