package com.production.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class PersistanceTest {
	enum Days {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	//Periode
			public static List<Long> periodeCalcul(LocalDateTime times1, LocalDateTime times2) {
				List<Long> r = new ArrayList<>();
				LocalDateTime tempDateTime = LocalDateTime.from(times1);

				long years = tempDateTime.until(times2, ChronoUnit.YEARS);
				tempDateTime = tempDateTime.plusYears(years);

				long months = tempDateTime.until(times2, ChronoUnit.MONTHS);
				tempDateTime = tempDateTime.plusMonths(months);

				long days = tempDateTime.until(times2, ChronoUnit.DAYS);
				tempDateTime = tempDateTime.plusDays(days);

				long hours = tempDateTime.until(times2, ChronoUnit.HOURS);
				tempDateTime = tempDateTime.plusHours(hours);

				long minutes = tempDateTime.until(times2, ChronoUnit.MINUTES);
				tempDateTime = tempDateTime.plusMinutes(minutes);

				long seconds = tempDateTime.until(times2, ChronoUnit.SECONDS);
				Long totalSeconds;
				totalSeconds = seconds + minutes * 60 + hours * 60 * 60 + days * 24 * 60 * 60 + months * 30 * 24 * 60 * 60
						+ years * 365 * 24 * 60 * 60;
				r.add(years);
				r.add(months);
				r.add(days);
				r.add(hours);
				r.add(minutes);
				r.add(seconds);
				r.add(totalSeconds);
				return r;
			}
	public static void main(String[] agrs) {
		LocalDateTime time1=LocalDateTime.parse("2020-01-20T00:09:22");
		LocalDateTime time2=LocalDateTime.parse("2020-02-01T00:10:22");
		LocalDateTime time3=LocalDateTime.parse("2020-01-20T02:12:11");
		LocalDateTime time4=LocalDateTime.parse("2020-01-20T02:13:11");
		int dif3 = (int)Duration.between(time1, time2).toMinutes()*60;
		System.out.println(Duration.between(time1, time2).toMinutes()*60);
		System.out.println(Duration.between(time1, time3).toMinutes()*60);
		int dif1 = (int) (Duration.between(time1, time3).toMinutes()*60);
		int dif2 = (int) (Duration.between(time4, time2).toMinutes()*60);
		System.out.println(" " + dif1 + " " + dif2 + "  " + (dif1+ dif2) + "  " + (dif3 - (dif1+dif2)));
		System.out.println(Duration.between(time4, time2).toMinutes()*60);
		System.out.println(Duration.between(time1, time3).toMinutes()*60+Duration.between(time4, time2).toMinutes()*60);
	}
}
