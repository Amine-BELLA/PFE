package com.production.demo.JsonHolder;

import java.util.Date;

public class VolumeParRoute {
	public Date debut;
	public Date fin;
	public Date time1;
	public Date time2;
	public Date getDebut() {
		return debut;
	}
	public void setDebut(Date debut) {
		this.debut = debut;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public Date getTime1() {
		return time1;
	}
	public void setTime1(Date time1) {
		this.time1 = time1;
	}
	public Date getTime2() {
		return time2;
	}
	public void setTime2(Date time2) {
		this.time2 = time2;
	}
	public VolumeParRoute(Date debut, Date fin, Date time1, Date time2) {
		super();
		this.debut = debut;
		this.fin = fin;
		this.time1 = time1;
		this.time2 = time2;
	}
	
	}
	
	

