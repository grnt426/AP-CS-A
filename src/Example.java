public class Example {
	public static void main(String[] args) {
		int blocks = 6;

		System.out.println("What can we build with " + blocks + " blocks?" );
		System.out.println(buildSomething(blocks));
	}

	public static String buildSomething(int totalBlocks) {
		if(totalBlocks > 5) {
			return "a tower";
		}
		else {
			return "nothing";
		}
	}
}
