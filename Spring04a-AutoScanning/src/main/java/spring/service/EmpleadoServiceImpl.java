package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.dao.IEmpleadoDao;
import spring.model.Empleado;
import spring.util.Simulaciones;

//Incluye las capas de servicios y lógica
@Service("employeeService")
public class EmpleadoServiceImpl implements IEmpleadoService{


	@Autowired
	private IEmpleadoDao employeeDao;
	
	
	public EmpleadoServiceImpl(){
		
	}
	

	public EmpleadoServiceImpl(IEmpleadoDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}




	public void registerEmployee(Empleado employee) {
		employee.setAssessmentDate(Simulaciones.fechaAleatoria1());
		employeeDao.saveInDatabase(employee);
	}
	
}
