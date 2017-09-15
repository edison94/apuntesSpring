package service;

/**
 *
 * @author Antonio
 */
public class ComidaImp implements IComida {

	public void caloriasComida(String comida) {
		int calorias;
		switch (comida) {
		case "lentejas":
			calorias = 500;
			break;
		case "judias":
			calorias = 600;
			break;
		case "garbanzos":
			calorias = 800;
			break;
		case "manteca_cacahuete_con_mantequilla":
			calorias = 3500;
			break;
		default:
			throw new AssertionError();
		}
		System.out.println(comida + ": " + calorias);
	}

}
