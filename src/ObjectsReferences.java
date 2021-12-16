public class ObjectsReferences {

	static class Dog{
		String name;
		String color;

		public Dog(String name, String color) {
			this.name = name;
			this.color = color;
		}

		public String toString() {
			return "a " + color + " dog named " + name + " " + super.toString();
		}
	}

	public static void main(String[] args) {
		Dog buddy = new Dog("Buddy", "White");
		System.out.println("I have " + buddy);
		System.out.println("I will send my dog to the Doggy Daycare\n");

		doggyDayCare(buddy);

		System.out.println("\nI got " + buddy + " from the Doggy Day Care!");
	}

	public static void doggyDayCare(Dog d) {
		d.color = "Dirty";

		d = new Dog("Enigma", "Pink");

		System.out.println("I am going to swap the dog out for " + d);
	}
}
