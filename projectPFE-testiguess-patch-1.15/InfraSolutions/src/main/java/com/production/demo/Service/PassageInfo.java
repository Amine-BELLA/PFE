package com.production.demo.Service;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.production.demo.JsonHolder.CartographieHolder;
import com.production.demo.JsonHolder.VolumeParResponseObject;
import com.production.demo.JsonHolder.VolumeParResponseParRoute;
import com.production.demo.Repository.Equipement;
import com.production.demo.Repository.PassageRepo;

@Service
public class PassageInfo {

	@Autowired
	private PassageRepo passageRepo;

	@Autowired
	private Equipement equipRepo;

	// Liste Days (Repartition Journaliere)
	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

	}

	// VolumeParPeriode
	public List<VolumeParResponseObject> volumeParPeriode(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		// Pageable p = PageRequest.of(page, size,
		// Sort.by("date").descending().and(Sort.by("time").descending()));
		List<VolumeParResponseObject> m = passageRepo.findVolumeParPeriode(rId, eId, mode, debutTime, finTime, typeP);
		return m;
	}

	// VolumeParClasse
	public List<VolumeParResponseObject> volumeParClasse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String[] classes, int[] voies) {
		// Pageable p = PageRequest.of(page, size,
		// Sort.by("date").descending().and(Sort.by("time").descending()));
		List<VolumeParResponseObject> m = passageRepo.findVolumeParClasse(rId, eId, mode, debutTime, finTime, classes,
				voies);
		return m;
	}

	// VolumeParRoute
	public List<VolumeParResponseParRoute> volumeParRoute(Long rId, Long[] eIds, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		// Pageable p = PageRequest.of(page, size,
		// Sort.by("date").descending().and(Sort.by("time").descending()));
		List<VolumeParResponseParRoute> m = passageRepo.findVolumeParRoute(rId, eIds, mode, debutTime, finTime, typeP);
		return m;
	}

	// VolumeParVoie
	public List<VolumeParResponseParRoute> volumeParVoie(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, int[] voies) {
		// Pageable p = PageRequest.of(page, size,
		// Sort.by("date").descending().and(Sort.by("time").descending()));
		List<VolumeParResponseParRoute> m = passageRepo.findVolumeParVoie(rId, eId, mode, debutTime, finTime, typeP,
				voies);
		return m;
	}

	// VolumeParSens
	public List<VolumeParResponseParRoute> volumeParSens(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String[] sens) {
		// Pageable p = PageRequest.of(page, size,
		// Sort.by("date").descending().and(Sort.by("time").descending()));
		List<VolumeParResponseParRoute> m = passageRepo.findVolumeParSens(rId, eId, mode, debutTime, finTime, typeP,
				sens);
		return m;
	}

	// ***** Graphes

	// GrapheVolumeParPeriode
	public List<Object[]> grapheVolumeParPeriode(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParPeriode(rId, eId, mode, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParClasse
	public List<Object[]> grapheVolumeParClasse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String classe, int[] voie) {
		List<Object[]> m = passageRepo.grapheVolumeParClasse(rId, eId, mode, debutTime, finTime, classe, voie);
		return m;
	}

	// GrapheVolumeParVitesse
	public Map<Integer, Integer> grapheVolumeParVitesse(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP, String sens) {
		List<Object[]> m = new ArrayList<>();
		m = passageRepo.grapheVolumeParVitesse(rId, eId, mode, debutTime, finTime, typeP, sens);
		Map<Integer, Integer> v = new HashMap<>();
		v.put(10, 0);
		v.put(20, 0);
		v.put(30, 0);
		v.put(40, 0);
		v.put(50, 0);
		v.put(60, 0);
		v.put(70, 0);
		v.put(80, 0);
		v.put(90, 0);
		v.put(100, 0);
		v.put(110, 0);
		v.put(120, 0);
		v.put(130, 0);
		v.put(140, 0);
		v.put(150, 0);
		v.put(160, 0);
		v.put(170, 0);
		v.put(180, 0);
		for (int i = 0; i < m.size(); i++) {
			v.put(((int) m.get(i)[0] / 10) * 10,
					v.get(((int) m.get(i)[0] / 10) * 10) + ((Long) m.get(i)[1]).intValue());
		}
		Map<Integer, Integer> s = new TreeMap<>(v);
		return s;
	}

	// GrapheVolumeParRoute
	public List<Object[]> grapheVolumeParRoute(Long rId, String mode, Long eId, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParRoute(rId, mode, eId, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParVoie
	public List<Object[]> grapheVolumeParVoie(Long rId, String mode, Long eId, int vId, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParVoie(rId, mode, eId, vId, debutTime, finTime, typeP);
		return m;
	}

	// GrapheVolumeParSens
	public List<Object[]> grapheVolumeParSens(Long rId, String mode, Long eId, String sens, LocalDateTime debutTime,
			LocalDateTime finTime, String typeP) {
		List<Object[]> m = passageRepo.grapheVolumeParSens(rId, mode, eId, sens, debutTime, finTime, typeP);
		return m;
	}

	// Menu Vehicules ****************************
	// Véhicule Table
	public List<VolumeParResponseObject> vehiculeTable(Long rId, String mode, Long eId, LocalDateTime debutTime,
			LocalDateTime finTime, int speed1, int speed2, int long1, int long2) {
		List<VolumeParResponseObject> m = passageRepo.vehiculeTable(rId, eId, mode, debutTime, finTime, speed1, speed2,
				long1, long2);
		return m;
	}

	// Véhicule Graphe(PL/PT)
	public Map<String, List<Integer>> graphePlPt(Long rId, Long eId, String mode, LocalDateTime debutTime,
			LocalDateTime finTime) {
		// ResultSet From SQL Query
		Map<String, List<Object[]>> m = new HashMap<>();
		// Result {"key":[2,7,...]...}
		Map<String, List<Integer>> list = new HashMap<>();

		m.put("Poids Lourd", passageRepo.graphePlPt(rId, eId, mode, debutTime, finTime, "VL"));
		m.put("Poids Total", passageRepo.graphePlPt(rId, eId, mode, debutTime, finTime, "T"));

		for (String key : m.keySet()) {
			List<Integer> holder = new ArrayList<>();
			for (int i = 0; i < 24; i++) {
				holder.add(0);
			}
			List<Object[]> listHeure = m.get(key);
			for (Object[] o : listHeure) {
				holder.set((Integer) o[0], ((Long) o[1]).intValue());
			}
			list.put(key, holder);

		}

		return list;

	}

	// MenuVitesse ****************************
	// Vitesse Par Periode (Horaire)
	public Map<String, List<Integer>> vitesseParH(Long rId, Long eid, String mode, LocalDateTime times1,
			LocalDateTime times2) {
		// ResultSet From SQL Query
		Map<String, List<Object[]>> m = new HashMap<>();
		// Result {"key":[2,7,...]...}
		Map<String, List<Integer>> list = new HashMap<>();
		List<String> listSens = passageRepo.voiesParReseau(rId);
		for (String s : listSens) {
			m.put("Poids Lourd" + "_" + s, passageRepo.vitesseParH(rId, eid, mode, times1, times2, "VL", s));
			m.put("Véhicule Leger" + "_" + s, passageRepo.vitesseParH(rId, eid, mode, times1, times2, "PL", s));
		}
		for (String key : m.keySet()) {
			List<Integer> holder = new ArrayList<>();
			for (int i = 0; i < 24; i++) {
				holder.add(0);
			}
			List<Object[]> listHeure = m.get(key);
			for (Object[] o : listHeure) {
				holder.set((Integer) o[0], ((Double) o[1]).intValue());
			}
			list.put(key, holder);

		}

		return list;

	}

	// Vitesse Par Periode (Journaliere)
	public Map<String, List<Integer>> vitesseParJ(Long rId, Long eid, String mode, LocalDateTime times1,
			LocalDateTime times2) {

		// ResultSet From SQL Query
		Map<String, List<Object[]>> m = new HashMap<>();
		// Result {"key":[2,7,...]...}
		Map<String, List<Integer>> list = new HashMap<>();
		List<String> listSens = passageRepo.voiesParReseau(rId);
		for (String s : listSens) {
			m.put("Véhicule Leger" + "_" + s, passageRepo.vitesseParJ(rId, eid, mode, times1, times2, "PL", s));
			m.put("Poids Lourd" + "_" + s, passageRepo.vitesseParJ(rId, eid, mode, times1, times2, "VL", s));
		}
		for (String key : m.keySet()) {

			Days[] days = Days.values();
			List<Object[]> listDays = m.get(key);
			List<Integer> holder = new ArrayList<>();
			int holderIndex = 0;
			for (int i = 0; i < 7; i++) {
				holder.add(0);
			}

			for (Days day : days) {

				int daySpeedCounter = 0;
				int daySpeed = 0;
				for (Object[] o : listDays) {
					if ((((LocalDate) o[0]).getDayOfWeek()).toString() == day.toString()) {
						daySpeed += ((Long) o[1]).intValue();
						daySpeedCounter += ((Long) o[2]).intValue();
					}
				}
				if (daySpeedCounter != 0) {
					holder.set(holderIndex, (int) (daySpeed / daySpeedCounter));
				}
				holderIndex += 1;
			}
			list.put(key, holder);
		}
		return list;
	}

	// Vitesse Par Classe
	public List<Double> vitesseParClasse(Long rId, Long eid, String mode, LocalDateTime times1, LocalDateTime times2,
			String classe, int voie) {
		List<Double> m = passageRepo.vitesseParClasse(rId, eid, mode, times1, times2, classe, voie);
		return m;

	}

	// Vitesse Par Route
	public List<Double> vitesseParRoute(Long rId, String mode, Long eId, LocalDateTime debutTime, LocalDateTime finTime,
			String typeP) {
		List<Double> m = passageRepo.vitesseParRoute(rId, mode, eId, debutTime, finTime, typeP);
		return m;
	}

	// TempReel
	public List<VolumeParResponseObject> tempReel(Long rId, Long eid, String mode, int[] num) {
		// Pageable p = PageRequest.of(page, size,
		// Sort.by("date").descending().and(Sort.by("time").descending()));
		return passageRepo.tempReel(rId, eid, mode, num);
	}

	// Parametre Suivi Chaussée
	// Aggressivité
	public Map<LocalDateTime, Double> aggre(Long rId, Long eId, LocalDateTime times1, LocalDateTime times2, int alpha) {
		List<Object[]> holder = passageRepo.findAxes(rId, eId, times1, times2);
		Map<LocalDateTime, Double> result = new HashMap<>();
		int ai = 0;
		int debutA = 0;
		if (!(holder.isEmpty())) {
			int finA = (int) holder.get(0)[3];
			while (ai < holder.size()) {

				Double countS = 0.0;
				Double countD = 0.0;
				Double countT = 0.0;
				List<Double> wtS = new ArrayList<>();
				List<Double> wtD = new ArrayList<>();
				List<Double> wtT = new ArrayList<>();

				Double a = 0.0;
				for (int j = debutA; j < finA; j++) {
					switch ((String) holder.get(j)[2]) {
					case "S":
						countS += 1;
						wtS.add(countS.intValue() - 1, Double.valueOf((int) holder.get(j)[1]));
						break;
					case "D":
						countD += 0.5;
						if (countD - countD.intValue() == 0.5) {
							wtD.add(countD.intValue(), Double.valueOf((int) holder.get(j)[1]));
						} else {
							wtD.set(countD.intValue() - 1,
									wtD.get(countD.intValue() - 1) + Double.valueOf((int) holder.get(j)[1]));
						}
						break;
					case "T":
						if (countT - countT.intValue() == 0.3 || countT - countT.intValue() == 0.0) {
							countT += 0.3;
						} else {
							countT += 0.4;
						}
						if (countT - countT.intValue() == 0.3) {
							wtT.add(countT.intValue(), Double.valueOf((int) holder.get(j)[1]));
						} else {
							wtT.set((int) Math.floor(countD - 0.1),
									wtT.get((int) Math.floor(countD - 0.1)) + Double.valueOf((int) holder.get(j)[1]));
						}
						break;
					default:
					}
				}

				switch (alpha) {
				case 4:
					for (Double wts : wtS) {
						a += Math.pow((wts / 13000), 4);
					}
					for (Double wtd : wtD) {
						a += 0.75 * Math.pow((wtd / 13000), 4);
					}
					for (Double wtt : wtT) {
						a += 1.1 * Math.pow((wtt / 13000), 4);
					}
					break;
				case 8:
					for (Double wts : wtS) {
						a += Math.pow((wts / 13000), 8);
					}
					for (Double wtd : wtD) {
						a += 12 * Math.pow((wtd / 13000), 8);
					}
					for (Double wtt : wtT) {
						a += 113 * Math.pow((wtt / 13000), 8);
					}
					break;
				case 12:
					for (Double wts : wtS) {
						a += Math.pow((wts / 13000), 12);
					}
					for (Double wtd : wtD) {
						a += 12 * Math.pow((wtd / 13000), 12);
					}
					for (Double wtt : wtT) {
						a += 113 * Math.pow((wtt / 13000), 12);
					}
					break;
				default:
					break;
				}

				result.put((LocalDateTime) holder.get(debutA)[0], a);
				debutA = finA;
				if (finA < holder.size()) {
					finA += (int) holder.get(finA)[3];
				}
				ai = debutA;

			}

			return result;
		} else {
			return result;
		}
	}

	// CAM
	public Double calculCam(Long rId, Long eId, LocalDateTime times1, LocalDateTime times2, int alpha) {
		Map<LocalDateTime, Double> aggres = this.aggre(rId, eId, times1, times2, alpha);
		int size = aggres.size();
		Double aggs = 0.0;
		for (Double agg : aggres.values()) {
			aggs += agg;
		}
		aggs = aggs / size;
		return aggs;
	}

	// Pourcentage Poids Lours
	public List<Double> pourcPl(Long rId, Long eId, String mode, LocalDateTime debutTime, LocalDateTime finTime) {
		Map<String, List<Integer>> m = this.graphePlPt(rId, eId, mode, debutTime, finTime);
		List<Double> val = new ArrayList<>();
		for (int i = 0; i < 23; i++) {
			if (m.get("Poids Lourd").get(i) != 0) {
				val.add(Double.valueOf((100 * m.get("Poids Lourd").get(i)) / m.get("Poids Total").get(i)));
			} else {
				val.add(0.0);
			}
		}
		return val;
	}

	// Taux D'Occupation
	public Map<String, Double> tauxOc(Long rId, Long eid, String mode, LocalDateTime times1, LocalDateTime times2) {
		List<Object[]> r = passageRepo.tauxOccup(rId, eid, mode, times1, times2);
		Map<String, Double> result = new HashMap<>();
		String date = (String) r.get(0)[0];
		Double occup = 0.0;
		for (int i = 0; i < r.size(); i++) {
			Object[] h = r.get(i);
			if (h[0] != date) {
				result.put(date, (3600 - occup) / 3600);
				date = (String) h[0];
				occup = Double.valueOf((int) h[1]);
			} else {
				occup += Double.valueOf((int) h[1]);
			}
		}
		return result;
	}

	// Taux D'Occupation 2
	public List<Object> tauxOc2(Long rId, Long eid, String mode, LocalDateTime times1, LocalDateTime times2) {
		List<Object> r = new ArrayList<>();
		List<Object[]> res = passageRepo.tauxOccup2(rId, eid, mode, times1, times2);
		int timeGap = 0;
		Long totalSeconds =  Duration.between(times1, times2).toMinutes()*60;
		DecimalFormat decimalFormat = new DecimalFormat("0.###");
		
		Double s  ;
		if(res.isEmpty()) {
			r.add("taux d'occupation : " + 0.0);
			
		}
		if (res.size() == 1) {
			s=1.0/(double)(totalSeconds);
			r.add("taux d'occupation : " +decimalFormat.format(s));
		} if(res.size()>1) {
			for (int i = 0; i < res.size()-1; i++) {
				timeGap += (int) res.get(i)[0];
				
			}

			Long firstTimeGap = Duration.between(times1, (LocalDateTime) res.get(res.size() - 1)[1]).toMinutes()*60;
			Long lastTimeGap = Duration.between((LocalDateTime) res.get(0)[1], times2).toMinutes()*60;
			timeGap += firstTimeGap;
			timeGap += lastTimeGap;
			Double d =100*(Double.valueOf(totalSeconds.intValue())- Double.valueOf(timeGap)) / Double.valueOf(totalSeconds.intValue());
			r.add("taux d'occupation : "  + decimalFormat.format(d));
			
		}
		r.add("nombre Totale des secondes dans cette Péiorde : " + totalSeconds);
		return r;
	}

	// NE
	public double calculNe(Long rId, Long eid, LocalDateTime times1, LocalDateTime times2, Double i, int n, Double c,
			int yearD, int alpha) {
		List<Long> tList = passageRepo.calculTJ(rId, eid, times1, times2);
		List<Object[]> plList = passageRepo.calculPl(rId, eid, times1, times2);
		List<Long> vcList = passageRepo.calculVc(rId, eid, times1, times2);
		int year = times1.getYear();
		int diffYear = Math.abs(year - yearD);
		// Parametre t
		Double t = 0.0;
		if (!(tList.isEmpty())) {
			for (Long s : tList) {
				t += Double.valueOf((Long) s) / Double.valueOf(tList.size());
			}
		}
		// Parametre Pl
		Double pl = 0.0;
		int cP = 0;
		int cV = 0;
		if (!(plList.isEmpty())) {
			for (Object[] o : plList) {
				if (plList.get(0)[0].equals("PL")) {
					cP += ((Long) o[1]).intValue();
				} else {
					cV += ((Long) o[1]).intValue();
				}
			}
		}
		// pl string????

		if (cP != 0 || cV != 0) {
			pl = (Double.valueOf(cP) / Double.valueOf(cP + cV));
		} else {
			pl = 0.0;
		}
		// Parametre Vc
		Double vc = 0.0;
		int vTot = 0;
		if (!(vcList.isEmpty())) {
			for (Long v : vcList) {
				vTot += ((Long) v).intValue();
			}
		}
		if (!(vcList.isEmpty())) {
			if (vTot != 0) {
				Collections.sort(vcList);
				vc = Double.valueOf((vcList.get(vcList.size() - 1)) / Double.valueOf(vTot));
			} else {
				vc = 0.0;

			}
		}
		Double cam = this.calculCam(rId, eid, times1, times2, alpha);
		if (cam.isNaN()) {
			cam = 0.0;
		}
		return 365 * t / Math.pow((1 + i), diffYear) * vc * pl * cam * c * (Math.pow(1 + i, n) - 1) / i;

	}

	// Surcharge Horaire
	public List<Integer> surchargeH(Long rId, Long eid, LocalDateTime times1, LocalDateTime times2) {
		List<Object[]> m = passageRepo.surchargeH(rId, eid, times1, times2, "Y");
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < 24; i++) {
			res.add(0);
		}
		for (Object[] o : m) {
			res.set((Integer) o[0], ((Long) o[1]).intValue());
		}
		return res;
	}

	// Surcharge Journaliere
	public List<Integer> surchargeJ(Long rId, Long eid, LocalDateTime times1, LocalDateTime times2) {
		Days[] days = Days.values();

		List<Object[]> listDays = passageRepo.surchargeJ(rId, eid, times1, times2, "Y");
		List<Integer> holder = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			holder.add(0);
		}
		int countList = -1;
		for (Days day : days) {
			countList += 1;
			for (Object[] o : listDays) {
				if ((((LocalDate) o[0]).getDayOfWeek()).toString() == day.toString()) {
					holder.set(countList, ((Long) o[1]).intValue());
				}
			}

		}
		return holder;

	}

	// Cartographie Info
	public List<CartographieHolder> getCarteInfo() {
		List<CartographieHolder> list = equipRepo.carteHolder();

		return list;
	}

	
}
