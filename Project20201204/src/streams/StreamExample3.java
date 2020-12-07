package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

import streams.lambda.Student;

public class StreamExample3 {
	public static void main(String[] args) {
		List<String> strList = Arrays.asList("Java8 lambda", "stream mapping");
		strList.stream().flatMap((t) -> Arrays.stream(t.split(" ")))
//				.filter(s -> s.startsWith("s"))
				.forEach(s -> System.out.println(s));

		strList.stream() //
				.map((t) -> t.toUpperCase()) //
				.forEach(s -> System.out.println(s));

		List<Student> students = Arrays.asList( //
				new Student("송다희", "F", 80), //
				new Student("윤태현", "M", 75), //
				new Student("이혜빈", "F", 85), //
				new Student("정병기", "M", 80));
		double avg = students.stream().mapToInt(new ToIntFunction<Student>() {
			@Override
			public int applyAsInt(Student s) {
				return s.getScore();
			}

		}).average().getAsDouble();
		System.out.println("평균: " + avg);
	}
}
