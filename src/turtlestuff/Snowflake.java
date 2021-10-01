package turtlestuff;

public class Snowflake {

	Turtle t;

	public Snowflake(Turtle t) {
		this.t = t;
	}

	public static void main(String[] args) throws InterruptedException {
		showLevels();
	}

	public static void showLevels() throws InterruptedException {
		Turtle t = new Turtle(1300, 1300);

		for(int levels = 0; levels < 7; levels++) {
			Snowflake f = new Snowflake(t);
			t.up();
//			t.clear();
			t.home();
			t.backward(600);
			t.right(90);
			t.backward(350);
			t.left(90);
			t.speed((int) (90 / (Math.pow(levels, 2) + 1)));
			t.down();

			for (int i = 0; i < 3; i++) {
				f.snowflake(1200, levels);
				t.right(120);
			}

			Thread.sleep(3000);
		}
	}

	public void snowflake(double length, int levels) {
		if(levels == 0) {
			t.forward(length);
			return;
		}

		length /= 3.0;
		snowflake(length, levels - 1);
		t.left(60);
		snowflake(length, levels - 1);
		t.right(120);
		snowflake(length, levels - 1);
		t.left(60);
		snowflake(length, levels - 1);
	}
}
