package com.production.demo;

import java.util.ArrayList;
import java.util.List;

import com.production.demo.PersistanceTest.Days;

public class PersistanceTest {
	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	public static void main(String[] agrs) {
		String s ="N°12 W°45";
		String[] q = s.split(" ");
		for(String n:q) {
			System.out.println(n);
		}
	}
}
