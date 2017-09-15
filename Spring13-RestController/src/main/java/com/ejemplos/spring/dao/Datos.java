package com.ejemplos.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ejemplos.spring.model.Provincia;
import com.ejemplos.spring.model.ProvinciaList;

@Repository
public class Datos {
	
	
	// Utility method to create country list.
	//Aunque no te lo creas, los datos los he buscado yo y lo he hecho yo
	//Sí, sí.. que esta vez es de verdad
		public List<Provincia> createProvinciaList() {
			List<Provincia> listaProvincias = new ArrayList<Provincia>();
			listaProvincias.add(new Provincia(4,"Almería","Andalucía",701211,8775));
			listaProvincias.add(new Provincia(11,"Cádiz","Andalucía",1240284,7440));
			listaProvincias.add(new Provincia(14,"Córdoba","Andalucía",795611,13771));
			listaProvincias.add(new Provincia(18,"Granada","Andalucía",917297,12647));
			listaProvincias.add(new Provincia(21,"Huelva","Andalucía",520017,10128));
			listaProvincias.add(new Provincia(23,"Jaén","Andalucía",654170,13496));
			listaProvincias.add(new Provincia(29,"Málaga","Andalucía",1628973,7306));
			listaProvincias.add(new Provincia(41,"Sevilla","Andalucía",1941480,14036));
			listaProvincias.add(new Provincia(22,"Huesca","Aragón",222909,15636));
			listaProvincias.add(new Provincia(44,"Teruel","Aragón",138932,14810));
			listaProvincias.add(new Provincia(50,"Zaragoza","Aragón",956006,17274));
			listaProvincias.add(new Provincia(33,"Asturias","Asturias, Principado de",1051229,10604));
			listaProvincias.add(new Provincia(7,"Illes Balears","Balears, Illes",1104479,4992));
			listaProvincias.add(new Provincia(35,"Palmas, Las","Canarias",1098406,4066));
			listaProvincias.add(new Provincia(38,"Santa Cruz de Tenerife","Canarias",1001900,3381));
			listaProvincias.add(new Provincia(39,"Cantabria","Cantabria",585179,5321));
			listaProvincias.add(new Provincia(5,"Ávila","Castilla y León",164925,8050));
			listaProvincias.add(new Provincia(9,"Burgos","Castilla y León",364002,14292));
			listaProvincias.add(new Provincia(24,"León","Castilla y León",479395,15581));
			listaProvincias.add(new Provincia(34,"Palencia","Castilla y León",166035,8052));
			listaProvincias.add(new Provincia(37,"Salamanca","Castilla y León",339395,12350));
			listaProvincias.add(new Provincia(40,"Segovia","Castilla y León",157570,6921));
			listaProvincias.add(new Provincia(42,"Soria","Castilla y León",91006,10306));
			listaProvincias.add(new Provincia(47,"Valladolid","Castilla y León",526288,8110));
			listaProvincias.add(new Provincia(49,"Zamora","Castilla y León",183436,10561));
			listaProvincias.add(new Provincia(02,"Albacete","Castilla-La Mancha",394580,14924));
			listaProvincias.add(new Provincia(13,"Ciudad Real","Castilla-La Mancha",513713,19813));
			listaProvincias.add(new Provincia(16,"Cuenca","Castilla-La Mancha",203841,17140));
			listaProvincias.add(new Provincia(19,"Guadalajara","Castilla-La Mancha",253686,12214));
			listaProvincias.add(new Provincia(45,"Toledo","Castilla-La Mancha",693371,15370));
			listaProvincias.add(new Provincia(8,"Barcelona","Cataluña",5523922,7728));
			listaProvincias.add(new Provincia(17,"Girona","Cataluña",753054,5910));
			listaProvincias.add(new Provincia(25,"Lleida","Cataluña",436029,12172));
			listaProvincias.add(new Provincia(43,"Tarragona","Cataluña",795101,6303));
			listaProvincias.add(new Provincia(03,"Alacant/Alicante","Comunitat Valenciana",1855047,5817));
			listaProvincias.add(new Provincia(12,"Castelló/Castellón","Comunitat Valenciana",582327,6636));
			listaProvincias.add(new Provincia(46,"València/Valencia","Comunitat Valenciana",2543315,10807));
			listaProvincias.add(new Provincia(06,"Badajoz","Extremadura",686730,21766));
			listaProvincias.add(new Provincia(10,"Cáceres","Extremadura",406267,19868));
			listaProvincias.add(new Provincia(15,"Coruña, A","Galicia",1127196,7950));
			listaProvincias.add(new Provincia(27,"Lugo","Galicia",339386,9856));
			listaProvincias.add(new Provincia(32,"Ourense","Galicia",318391,7273));
			listaProvincias.add(new Provincia(36,"Pontevedra","Galicia",947374,4495));
			listaProvincias.add(new Provincia(28,"Madrid","Madrid, Comunidad de",6436996,8028));
			listaProvincias.add(new Provincia(30,"Murcia","Murcia, Región de",1467288,11314));
			listaProvincias.add(new Provincia(31,"Navarra","Navarra, Comunidad Foral de",640476,10391));
			listaProvincias.add(new Provincia(01,"Araba/Álava","País Vasco",323648,3037));
			listaProvincias.add(new Provincia(48,"Bizkaia","País Vasco",1148775,2217));
			listaProvincias.add(new Provincia(20,"Gipuzkoa","País Vasco",716834,1980));
			listaProvincias.add(new Provincia(26,"Rioja, La","Rioja, La",317053,5045));
			return listaProvincias;
		}
		//Para una prueba con XML
		public static ProvinciaList createProvinciaList2() {
			List<Provincia> listaProvincias = new ArrayList<Provincia>();
			listaProvincias.add(new Provincia(4,"Almería","Andalucía",701211,8775));
			listaProvincias.add(new Provincia(11,"Cádiz","Andalucía",1240284,7440));
			listaProvincias.add(new Provincia(14,"Córdoba","Andalucía",795611,13771));
			listaProvincias.add(new Provincia(18,"Granada","Andalucía",917297,12647));
			listaProvincias.add(new Provincia(21,"Huelva","Andalucía",520017,10128));
			listaProvincias.add(new Provincia(23,"Jaén","Andalucía",654170,13496));
			listaProvincias.add(new Provincia(29,"Málaga","Andalucía",1628973,7306));
			listaProvincias.add(new Provincia(41,"Sevilla","Andalucía",1941480,14036));
			listaProvincias.add(new Provincia(22,"Huesca","Aragón",222909,15636));
			listaProvincias.add(new Provincia(44,"Teruel","Aragón",138932,14810));
			listaProvincias.add(new Provincia(50,"Zaragoza","Aragón",956006,17274));
			listaProvincias.add(new Provincia(33,"Asturias","Asturias, Principado de",1051229,10604));
			listaProvincias.add(new Provincia(7,"Illes Balears","Balears, Illes",1104479,4992));
			listaProvincias.add(new Provincia(35,"Palmas, Las","Canarias",1098406,4066));
			listaProvincias.add(new Provincia(38,"Santa Cruz de Tenerife","Canarias",1001900,3381));
			listaProvincias.add(new Provincia(39,"Cantabria","Cantabria",585179,5321));
			listaProvincias.add(new Provincia(5,"Ávila","Castilla y León",164925,8050));
			listaProvincias.add(new Provincia(9,"Burgos","Castilla y León",364002,14292));
			listaProvincias.add(new Provincia(24,"León","Castilla y León",479395,15581));
			listaProvincias.add(new Provincia(34,"Palencia","Castilla y León",166035,8052));
			listaProvincias.add(new Provincia(37,"Salamanca","Castilla y León",339395,12350));
			listaProvincias.add(new Provincia(40,"Segovia","Castilla y León",157570,6921));
			listaProvincias.add(new Provincia(42,"Soria","Castilla y León",91006,10306));
			listaProvincias.add(new Provincia(47,"Valladolid","Castilla y León",526288,8110));
			listaProvincias.add(new Provincia(49,"Zamora","Castilla y León",183436,10561));
			listaProvincias.add(new Provincia(02,"Albacete","Castilla-La Mancha",394580,14924));
			listaProvincias.add(new Provincia(13,"Ciudad Real","Castilla-La Mancha",513713,19813));
			listaProvincias.add(new Provincia(16,"Cuenca","Castilla-La Mancha",203841,17140));
			listaProvincias.add(new Provincia(19,"Guadalajara","Castilla-La Mancha",253686,12214));
			listaProvincias.add(new Provincia(45,"Toledo","Castilla-La Mancha",693371,15370));
			listaProvincias.add(new Provincia(8,"Barcelona","Cataluña",5523922,7728));
			listaProvincias.add(new Provincia(17,"Girona","Cataluña",753054,5910));
			listaProvincias.add(new Provincia(25,"Lleida","Cataluña",436029,12172));
			listaProvincias.add(new Provincia(43,"Tarragona","Cataluña",795101,6303));
			listaProvincias.add(new Provincia(03,"Alacant/Alicante","Comunitat Valenciana",1855047,5817));
			listaProvincias.add(new Provincia(12,"Castelló/Castellón","Comunitat Valenciana",582327,6636));
			listaProvincias.add(new Provincia(46,"València/Valencia","Comunitat Valenciana",2543315,10807));
			listaProvincias.add(new Provincia(06,"Badajoz","Extremadura",686730,21766));
			listaProvincias.add(new Provincia(10,"Cáceres","Extremadura",406267,19868));
			listaProvincias.add(new Provincia(15,"Coruña, A","Galicia",1127196,7950));
			listaProvincias.add(new Provincia(27,"Lugo","Galicia",339386,9856));
			listaProvincias.add(new Provincia(32,"Ourense","Galicia",318391,7273));
			listaProvincias.add(new Provincia(36,"Pontevedra","Galicia",947374,4495));
			listaProvincias.add(new Provincia(28,"Madrid","Madrid, Comunidad de",6436996,8028));
			listaProvincias.add(new Provincia(30,"Murcia","Murcia, Región de",1467288,11314));
			listaProvincias.add(new Provincia(31,"Navarra","Navarra, Comunidad Foral de",640476,10391));
			listaProvincias.add(new Provincia(01,"Araba/Álava","País Vasco",323648,3037));
			listaProvincias.add(new Provincia(48,"Bizkaia","País Vasco",1148775,2217));
			listaProvincias.add(new Provincia(20,"Gipuzkoa","País Vasco",716834,1980));
			listaProvincias.add(new Provincia(26,"Rioja, La","Rioja, La",317053,5045));
			
			
			ProvinciaList listado = new ProvinciaList(listaProvincias);
			return listado;
		}		

}
