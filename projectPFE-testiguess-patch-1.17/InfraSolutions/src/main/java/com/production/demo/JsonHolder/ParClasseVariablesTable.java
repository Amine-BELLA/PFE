package com.production.demo.JsonHolder;

public class ParClasseVariablesTable extends RepeatingVariables {
	public String sens;
	public String[] classes;
	public String getSens() {
		return sens;
	}
	public void setSens(String sens) {
		this.sens = sens;
	}
	public String[] getClasses() {
		return classes;
	}
	public void setClasses(String[] classes) {
		this.classes = classes;
	}
	public ParClasseVariablesTable(String sens, String[] classes) {
		super();
		this.sens = sens;
		this.classes = classes;
	}
	
	
}
