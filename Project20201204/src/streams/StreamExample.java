package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleConsumer;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
	public static void main(String[] args) {
		List<String> list = null;
		list = Arrays.asList("Hong", "Hwang", "Park", "Choi");

		Stream<String> stream = list.stream();
		stream.filter((t) -> t.length() > 3) //
				.forEach((t) -> System.out.println(t));

		// BaseStream -> Stream<T>, IntStream, LongStream, DoubleStream
		// IntStream: Stream<Integer>, LongStream: Stream<Long>
		String[] strAry = { "Hong", "Hwang", "Park" };
		Stream<String> strStream = Arrays.stream(strAry);

		int[] intAry = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(intAry);
		int sum = intStream.sum();
		System.out.println("합: " + sum);

		double[] dblAry = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		DoubleStream dblStream = Arrays.stream(dblAry);
		dblStream.forEach(new DoubleConsumer() {
			double result = 0;

			@Override
			public void accept(double value) {
				result += value;
				System.out.println(result);
			}
		});

		IntStream is = IntStream.range(1, 10);
		is.forEach(n -> System.out.println(n));

		is = IntStream.rangeClosed(1, 10);
		System.out.println("합: " + is.sum());

		Path path = Paths.get("list.txt");
		try {
			Stream<String> stream1 = Files.lines(path);
			stream1.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}

		path = Paths.get("C:\\Program Files");
		try {
			Stream<Path> pStream = Files.list(path);
			pStream.forEach(s -> System.out.println(s));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}