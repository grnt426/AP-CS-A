package turtlestuff;

public class TriangleSpiral {

	static int[] colors = new int[512];
	static Turtle t = new Turtle(1300, 1300);

	public static void main(String[] args) throws InterruptedException {

		for(int i = 0; i < 512; i++) {
			colors[i] = i < 256 ? i : 256 - (i - 255);
		}

		t.left(90);
		t.speed(50);

		// Draw triangular
		drawSpiral(121, 4, 1.0, 600);

		// Draw Square
//		drawSpiral(t, 91, 3, 1.0, 700);

		// Draw Hexagonal
//		drawSpiral(t, 61, 3, .3, 800);

		// Draw Pentagon
//		drawSpiral(t, 71, 3, .5, 800);
	}

	public static void drawSpiral(int angle, int step, double stepFactor, int lines) {
		for(int i = 0; i < lines; i++) {
			colorize(i);
			t.forward(step * i * stepFactor);
			t.left(angle);
		}
	}

	public static void colorize(int i) {
		t.penColor(colors[(i+70)  % 512], colors[(i+140)  % 512], colors[(i+210)  % 512]);
	}
}
