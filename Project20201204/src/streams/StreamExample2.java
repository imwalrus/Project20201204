package streams;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class StreamExample2 {
	public static void main(String[] args) {
		// 1~100
		IntStream.range(1, 101).forEach(a -> System.out.println(a));

		// 짝수만 결과를 출력
		IntStream.rangeClosed(1, 100) //
				.filter(b -> b % 2 == 0) //
				.forEach(c -> System.out.println(c));

		int sum = IntStream.rangeClosed(1, 100) //
				.filter(b -> b % 2 == 0) //
				.sum();
		System.out.println(sum);

		int[] intAry = { 2, 4, 6, 8, 1, 9 };
		IntStream is = Arrays.stream(intAry);
		OptionalInt max = is.max();
		System.out.println(max);

		int iMax = max.getAsInt();
		System.out.println("최대값: " + iMax);

		is = Arrays.stream(intAry);
		int min = is.min().getAsInt();
		System.out.println("최소값: " + min);

		is = Arrays.stream(intAry);
		double avg = is.average().getAsDouble();
		System.out.println("평균값: " + avg);

		// 조건(filter)
		Arrays.stream(intAry).filter((int a) -> a % 2 == 0) //
				.forEach((a) -> System.out.println(a));

	}
}
