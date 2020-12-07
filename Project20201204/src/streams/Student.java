package streams;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	@Override
	public int compareTo(Student o) {
		// 오름차순 = 음수, 같다 = 0, 내림차순 = 양수
		return this.score - o.score;
// =	if (this.score > o.score)
//			return -1;
//		else
//			return 1;
	}
}