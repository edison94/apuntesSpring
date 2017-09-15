package service;

public class ComidaConsolaImp implements IComida{

	public void caloriasComida(String comida) {
		int calorias = 0;
		switch(comida){
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
		}
		System.out.println(comida+" tiene "+ calorias+" calorias");
		
	}

}
