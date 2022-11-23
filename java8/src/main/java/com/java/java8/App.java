package com.java.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		// lambdaStreams();
		// trywithresouce();
		// newDateTimeApi();
		// ZonedTimeAndDate();
		// periodDuration();
		optional();

	}

	private static void optional() {
		String[] str = new String[10];
		str[5] = "JAVA OPTIONAL CLASS EXAMPLE"; // Setting value for 5th index
		// It returns an empty instance of Optional class
		Optional<String> empty = Optional.empty();
		System.out.println(empty);
		// It returns a non-empty Optional
		Optional<String> value = Optional.of(str[5]);
		// If value is present, it returns an Optional otherwise returns an empty
		// Optional
		System.out.println("Filtered value: " + value.filter((s) -> s.equals("Abc")));
		System.out.println("Filtered value: " + value.filter((s) -> s.equals("JAVA OPTIONAL CLASS EXAMPLE")));
		// It returns value of an Optional. if value is not present, it throws an
		// NoSuchElementException
		System.out.println("Getting value: " + value.get());
		// It returns hashCode of the value
		System.out.println("Getting hashCode: " + value.hashCode());
		// It returns true if value is present, otherwise false
		System.out.println("Is value present: " + value.isPresent());
		// It returns non-empty Optional if value is present, otherwise returns an empty
		// Optional
		System.out.println("Nullable Optional: " + Optional.ofNullable(str[5]));
		// It returns value if available, otherwise returns specified value,
		System.out.println("orElse: " + value.orElse("Value is not present"));
		System.out.println("orElse: " + empty.orElse("Value is not present"));
		value.ifPresent(System.out::println); // printing value by using method reference
		
		Modem m = new Modem(11);
		
		Optional o = Optional.ofNullable(m.getPrice());
	}

	public boolean priceIsInRange2(Modem modem2) {
	     return Optional.ofNullable(modem2)
	       .map(Modem::getPrice)
	       .filter(p -> p >= 10)
	       .filter(p -> p <= 15)
	       .isPresent();
	 }
	private static void periodDuration() {

		LocalDateTime ld1 = LocalDateTime.of(2022, 11, 20, 15, 45);
		LocalDateTime ld2 = LocalDateTime.of(2022, 11, 30, 15, 45);
		Period p = Period.between(ld1.toLocalDate(), ld2.toLocalDate());
		System.out.println(p.getDays());

	}

	private static void ZonedTimeAndDate() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String formattedCurrentDate = date.format(format1);

		System.out.println("formatted current Date and" + " Time : " + formattedCurrentDate);

		// to get the current zone
		ZonedDateTime currentZone = ZonedDateTime.now();
		System.out.println("the current zone is " + currentZone.getZone());
		System.out.println("the current zoned time is " + currentZone);
		System.out.println("the current localdate time is " + date);
		// getting time zone of specific place
		// we use withZoneSameInstant(): it is
		// used to return a copy of this date-time
		// with a different time-zone,
		// retaining the instant.
		ZoneId tokyo = ZoneId.of("Asia/Tokyo");

		ZonedDateTime tokyoZone = currentZone.withZoneSameInstant(tokyo);

		System.out.println("tokyo time zone is " + tokyoZone);

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String formatedDateTime = tokyoZone.format(format);

		System.out.println("formatted tokyo time zone " + formatedDateTime);
	}

	static void newDateTimeApi() {
		// the current date
		LocalDate date = LocalDate.now();
		System.out.println("the current date is " + date);

		// the current time
		LocalTime time = LocalTime.now();
		System.out.println("the current time is " + time);

		// will give us the current time and date
		LocalDateTime current = LocalDateTime.now();
		System.out.println("current date and time : " + current);

		// to print in a particular format
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String formatedDateTime = current.format(format);

		System.out.println("in formatted manner " + formatedDateTime);

		// printing months days and seconds
		Month month = current.getMonth();
		int day = current.getDayOfMonth();
		int seconds = current.getSecond();
		System.out.println("Month : " + month + " day : " + day + " seconds : " + seconds);

		// printing some specified date
		LocalDate date2 = LocalDate.of(1950, 1, 26);
		System.out.println("the republic day :" + date2);

		// printing date with current time.
		LocalDateTime specificDate = current.withDayOfMonth(24).withYear(2016).withDayOfMonth(10);

		System.out.println("specific date with " + "current time : " + specificDate);

		LocalDateTime ld = LocalDateTime.of(1988, 3, 23, 4, 45);
		System.out.println(ld);

	}

	static void trywithresouce() throws IOException {
		/*
		 * BufferedReader br = null; try { br = new BufferedReader(new
		 * InputStreamReader(System.in)); br.readLine(); }finally { br.close(); }
		 */

		try (BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in))) {
			br2.readLine();
			System.out.println(br2);
		}

	}

	static void lambdaStreams() {

		List<Integer> list = Arrays.asList(10, 4, 6, 8, 3, 5);
		/*
		 * list.forEach((f) -> { System.out.println(" : " + f); });
		 */

		// list.forEach(StaticC :: printS);
		// list.forEach(System.out :: println);
		// list.forEach(new StaticC() :: printNontS);

		/*
		 * list.stream().filter(new Predicate<Integer>() {
		 * 
		 * public boolean test(Integer t) {
		 * 
		 * return t % 2 == 0; }
		 * 
		 * }).forEach(t -> System.out.println(t));
		 * 
		 * list.stream().filter(t -> t % 2 == 0).forEach(System.out::println);
		 */

		list.stream().filter(t -> t % 2 == 0).map(t -> t * 10).forEach(t -> System.out.println(t));
		System.out.println("**********");
		Optional<Integer> opt = list.stream().filter(t -> t % 2 == 0).map(t -> t * 10).findFirst();
		if (opt.isPresent()) {
			System.out.println(opt.toString());
		}
		System.out.println("***********");
		Integer sum = list.stream().filter(t -> t % 2 == 0).map(t -> t * 10).reduce(0, (a, b) -> a + b);
		System.out.println(sum);
		// System.out.println(list);

		list.stream().map(new Function<Integer, Integer>() {

			public Integer apply(Integer t) {
				return t * 2;
			}

		}).forEach(System.out::println);

		Integer sums = list.stream().filter(t -> t % 2 == 0).map(t -> t * 10).reduce(0, (a, b) -> {
			return (a + b);
		});

	}

	class StaticC {
		/*
		 * static void printS(Integer s) {
		 * System.out.println("Int version The print statment is : " + s); }
		 */

		void printNontS(Integer s) {
			System.out.println("Int version, Non static The print statment is : " + s);
		}
	}

}