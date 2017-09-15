package service;

public class EncriptadorImpPGP implements IEncriptador{

	public void encriptar(String msg) {
		System.out.println("Encriptando en formato PGP el mensaje: "+msg);
	}

}
