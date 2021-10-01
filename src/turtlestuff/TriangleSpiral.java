package turtlestuff;

public class TriangleSpiral {

	public static void main(String[] args) throws InterruptedException {
		Turtle t = new Turtle(1300, 1300);
		t.left(90);
		t.speed(50);

		double angle = 61;
		double stepFactor = .4;
		for(int i = 0; i < 700; i++) {
			t.forward(3 * i * stepFactor);
			t.left(angle);
		}
	}
}
