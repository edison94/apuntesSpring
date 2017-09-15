package ejemplos.hibernate.util;

import java.util.Date;

/**
 *
 * @author Antonio
 */
public class Simulaciones {

    public static int numeroAleatorio(int cantidad) {
        return (1 + (int) (Math.random() * cantidad));
    }

    public static int posAleatorioArray(int cantidad) {
        return ((int) (Math.random() * cantidad));
    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static String textoAleatorio(int numLetras) {
        String[] cad = {"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed tempor ultricies faucibus. Nam faucibus felis vitae tincidunt imperdiet. Nullam iaculis lacus auctor nunc fermentum iaculis. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Maecenas non arcu vel orci elementum pretium vel eu felis. Maecenas eros neque, cursus eu mi id, hendrerit lobortis urna. Curabitur tristique quis massa in pellentesque. Nunc interdum metus eu enim pulvinar auctor",
            "Nunc varius elementum quam nec dapibus. Maecenas malesuada, arcu a tristique dignissim, eros erat elementum ipsum, vel molestie nibh erat nec turpis. Integer in consequat ipsum, fringilla congue erat. Pellentesque faucibus lacus ac odio vestibulum, at pulvinar orci consequat. Nullam euismod blandit leo, sit amet rhoncus felis placerat ut. Cras pulvinar viverra molestie. Maecenas nec maximus felis",
            "Nulla vitae maximus ex, a vulputate urna. Pellentesque pulvinar leo urna, non volutpat dui semper et. Cras dapibus vel arcu eget sodales. Donec suscipit turpis in eros molestie finibus quis sed quam. Integer placerat molestie ultricies. Maecenas commodo arcu quis scelerisque faucibus. Praesent efficitur ante eu metus dictum, ut ullamcorper odio dignissim. Nunc semper placerat pretium. Praesent gravida nibh a felis eleifend mattis eu eget ipsum. In scelerisque malesuada massa quis scelerisque"};

        String eleccion = cad[posAleatorioArray(cad.length)];
        int tam = eleccion.length();
        String subcadena = eleccion.substring(tam - numLetras, tam);
        return subcadena;
    }

    public static Date fechaAleatoria() {

        // SI .. ya sé que se puede hacer mejor.. y que esta deprecated.. pero queria algo rápido
        // Aqui tenes algunas ideas
        // http://stackoverflow.com/questions/3985392/generate-random-date-of-birth
        //Los años empiezan en 1900
        int year = randBetween(105, 115);
        System.out.println("---- " + year);
        int dia = randBetween(1, 31);
        int mes = randBetween(1, 12);
        return new Date(year, mes, dia);
    }

    public static int codigoTelefono() {
        //Obtengo un código de Pais de 2 cifrs        
        return Simulaciones.randBetween(1, 99);
    }

    public static String numTelefono() {
        //Obtengo un número String de 9 cifras        
        return "" + Simulaciones.randBetween(100000000, 999999999);
    }

    public static String tipoTelefono() {
        //Para el tipo elijo un valor de 1 a 5;        
        int aux = Simulaciones.numeroAleatorio(5);
        if (aux <= 2) {
            return "Fijo";
        } else if (aux <= 4) {
            return "Movil";
        } else {
            return "chati";
        }
    }

    public static String convertirANumerosRomanos(int numero) {
        // http://puntocomnoesunlenguaje.blogspot.com.es/2014/12/convertir-numeros-romanos-en-java.html
        int i, miles, centenas, decenas, unidades;
        String romano = "";
        //obtenemos cada cifra del número
        miles = numero / 1000;
        centenas = numero / 100 % 10;
        decenas = numero / 10 % 10;
        unidades = numero % 10;

        //millar
        for (i = 1; i <= miles; i++) {
            romano = romano + "M";
        }

        //centenas
        if (centenas == 9) {
            romano = romano + "CM";
        } else if (centenas >= 5) {
            romano = romano + "D";
            for (i = 6; i <= centenas; i++) {
                romano = romano + "C";
            }
        } else if (centenas == 4) {
            romano = romano + "CD";
        } else {
            for (i = 1; i <= centenas; i++) {
                romano = romano + "C";
            }
        }

        //decenas
        if (decenas == 9) {
            romano = romano + "XC";
        } else if (decenas >= 5) {
            romano = romano + "L";
            for (i = 6; i <= decenas; i++) {
                romano = romano + "X";
            }
        } else if (decenas == 4) {
            romano = romano + "XL";
        } else {
            for (i = 1; i <= decenas; i++) {
                romano = romano + "X";
            }
        }

        //unidades
        if (unidades == 9) {
            romano = romano + "IX";
        } else if (unidades >= 5) {
            romano = romano + "V";
            for (i = 6; i <= unidades; i++) {
                romano = romano + "I";
            }
        } else if (unidades == 4) {
            romano = romano + "IV";
        } else {
            for (i = 1; i <= unidades; i++) {
                romano = romano + "I";
            }
        }
        return romano;
    }

    public static String sufijoNombre() {
        return " " + convertirANumerosRomanos(numeroAleatorio(50));
    }

}
