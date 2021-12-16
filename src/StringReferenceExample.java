public class StringReferenceExample {
	public static void main(String[] args) {
		String name = "Jake";
		mystery(name);
		System.out.println(name);
	}

	private static void mystery(String name) {
		name = "Hi, " + name + "!";
	}
}
