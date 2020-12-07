package streams.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class LambdaExample {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList( //
				new Student("Hong", "MALE", 70), //
				new Student("Hwang", "FEMALE", 80), //
				new Student("Park", "MALE", 90), //
				new Student("Choi", "FEMALE", 85)); //

		// 1. 여학생정보 : 이름 - 점수 출력
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				System.out.println(student.getName() + " - " + student.getScore());
			}
		}

		// 2. 전체학생 : 점수 80점 초과하는 학생 출력
		for (Student student : list) {
			if (student.getScore() > 80) {
				System.out.println("80점 초과 학생: " + student.getName());
			}
		}

		// 3. 남학생의 총점 출력 (남학생 총점: 160점)
		int sum = 0;
		for (Student student : list) {
			if (student.getSex().equals("MALE")) {
				sum += student.getScore();
			}
		}
		System.out.println("남학생 총점: " + sum + "점");

		// 4. 여학생의 평균 출력 (여학생 평균 : 82.5점)
		int sum1 = 0, count = 0;
		for (Student student : list) {
			if (student.getSex().equals("FEMALE")) {
				count++;
				sum1 += student.getScore();
			}
		}
		System.out.println("여학생 평균: " + (double) sum1 / count + "점");

		System.out.println("--------------------------");
		System.out.println("[스트림]");
		// 반복문 (반복자) : 스트림(반복자)
		// 스트림 생성 -> 소진.
		Stream<Student> stream = list.stream();
		stream.filter((t) -> t.getSex().equals("FEMALE"))
				.forEach((t) -> System.out.println(t.getName() + " - " + t.getScore()));

		stream = list.stream();
		stream.filter((t) -> t.getScore() > 80) //
				.forEach((t) -> System.out.println("80점 초과 학생: " + t.getName()));

		int sum2 = list.stream().filter(t -> t.getSex().equals("MALE")) //
				.mapToInt((value) -> value.getScore()) //
				.sum();
		System.out.println("남학생 총점: " + sum2 + "점");

		double avg = list.stream().filter(t -> t.getSex().equals("FEMALE")) //
				.mapToInt(s -> s.getScore()) //
				.average() //
				.getAsDouble();
		System.out.println("여학생 평균: " + avg + "점");
	}
}