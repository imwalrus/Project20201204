package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectExample {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList( //
				new Student("Hong", 80), //
				new Student("Hwang", 90), //
				new Student("Park", 87) //
		);

		List<Student> student80s = list.stream() //
				.filter(s -> s.getScore() / 10 == 8) //
				.sorted() //
				.collect(Collectors.toList());

		for (Student student : student80s) {
			System.out.println("이름: " + student.getName() + ", 점수: " + student.getScore());
		}

		Map<String, Integer> map = list.stream() //
				.filter(s -> s.getScore() / 10 == 8) //
				.sorted() //
				.collect( //
						Collectors.toMap( //
								(t) -> t.getName(), //
								(t) -> t.getScore() //
						) //
				);
		Set<String> set = map.keySet();
		for (String key : set) {
			System.out.println("Key: " + key + ", Val: " + map.get(key));
		}
	}
}
