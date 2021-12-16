package ifandnumbers;

public class IfStatements {
	public static void main(String[] args) {

		Integer five = 5;
		int p = 5;

		if(p == five) {
			System.out.println("They are the same");
		}

		int cookies = 13;
		System.out.println("Who wants cookies for twelve people?");

		if(cookies >= 12) {
			System.out.println("We have more than enough cookies!");
		}

		System.out.println("Let's share the cookies");


		System.out.println("Do we have enough cookies?");

		if(cookies > 12) {
			System.out.println("We have more than enough cookies!");
		}
		else if(cookies < 12)

		System.out.println("Let's share the cookies");
	}
}
