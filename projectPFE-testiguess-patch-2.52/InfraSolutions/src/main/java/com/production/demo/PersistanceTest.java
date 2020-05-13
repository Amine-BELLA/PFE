package com.production.demo;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;

import com.production.demo.Model.Equipement;
import com.production.demo.Model.Passage;
import com.production.demo.Model.Vehicule;

public class PersistanceTest {

	public static void main(String[] args) {
		Passage passage1 = new Passage(LocalDate.of(2000, 02, 11),LocalTime.of(01, 11, 30),"EU13-1",120,false,111, 200, "PL", 21);
		Passage passage2 = new Passage(LocalDate.of(2000, 02, 11),LocalTime.of(01, 11, 30),"EU13-1",120,false,111, 200, "PL", 21);
		Passage passage3 = new Passage(LocalDate.of(2002, 02, 11),LocalTime.of(01, 11, 30),"EU13-1",120,false,111, 200, "PL", 21);
		Passage passage4 = new Passage(LocalDate.of(2003, 02, 11),LocalTime.of(01, 11, 30),"EU13-1",120,false,111, 200, "PL", 21);
		
		
		Equipement equip1 = new Equipement("Model1","NumSer1","PP","Fourn1");
		Equipement equip2 = new Equipement("Model2","NumSer2","CP","Fourn2");
		Equipement equip3 = new Equipement("Model3","NumSer3","PP","Fourn3");
		
		Vehicule vehic1 = new Vehicule(11,"sil11",3);
		Vehicule vehic2 = new Vehicule(12,"sil12",2);
		Vehicule vehic3 = new Vehicule(13,"sil13",2);
		
		 
	}

}
