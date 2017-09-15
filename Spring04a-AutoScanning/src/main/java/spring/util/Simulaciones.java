package spring.util;

import java.util.Date;
import org.joda.time.LocalDate;

public class Simulaciones {
	
	
    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
    
    public static LocalDate fechaAleatoria1() {

        // Si.. ya sé que pueden existir fechas raras.. lo sé.. soy consciente
        int year = randBetween(2010, 2015);
        int dia = randBetween(1, 31);
        int mes = randBetween(1, 12);
        return new LocalDate(year, mes, dia);
    }
    

	
	
    public static Date fechaAleatoria2() {

        // SI .. ya sé que se puede hacer mejor.. y que esta deprecated.. pero queria algo rápido
        // Aqui tenes algunas ideas
        // http://stackoverflow.com/questions/3985392/generate-random-date-of-birth
        //Los años empiezan en 1900
        int year = randBetween(105, 115);
        int dia = randBetween(1, 31);
        int mes = randBetween(1, 12);
        return new Date(year, mes, dia);
    }

}
