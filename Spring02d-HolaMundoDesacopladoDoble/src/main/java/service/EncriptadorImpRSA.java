package service;

public class EncriptadorImpRSA implements IEncriptador{

	public void encriptar(String msg) {
		System.out.println("Encriptando en formato RSA el mensaje: "+msg);
	}

}
