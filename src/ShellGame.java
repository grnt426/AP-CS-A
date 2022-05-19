import java.io.BufferedReader;
import java.io.FileReader;

public class ShellGame {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader("shell.in"));
		int swaps = Integer.parseInt(reader.readLine());
		String[] swapsAndGuesses = new String[swaps];
		String line;
		int index = 0;

		// Read in all the swap and guesses information
		while ((line = reader.readLine()) != null) {
			swapsAndGuesses[index] = line;
			index++;
		}

		// The number of correct guesses for each initial shell location
		int[] scores = {0, 0, 0, 0};

		// Try the pebble under each shell location (1, 2, and 3)
		for(int i = 1; i < 4; i++) {

			// Set the pebble to the location where we are hiding it this round
			boolean[] location = {false, false, false, false};
			location[i] = true;

			// Run through all the swaps and guesses
			for(String data: swapsAndGuesses) {
				String[] swapData = data.split(" ");
				int guess = Integer.parseInt(swapData[2]);
				int left = Integer.parseInt(swapData[0]);
				int right = Integer.parseInt(swapData[1]);

				boolean temp = location[left];
				location[left] = location[right];
				location[right] = temp;

				// We get a point for the original starting position if the pebble is still there
				if(location[guess]) {
					scores[i]++;
				}
			}
		}

		// Now, just find the maximum score
		int max = 0;
		for(int s : scores)
			max = Math.max(max, s);

		System.out.println(max);
	}
}
