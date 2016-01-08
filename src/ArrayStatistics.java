/**
 * An implemenation of a solution to Problem 2 on Problem set 6 from COSI11. There are intentional errors
 * included, in order to demonstrate some of the error checking capabilities of eclipse. 
 * @author Grady
 *
 */
public class ArrayStatistics {
	
	/**
	 * The main method will test our implementation of the array statistics methods that we have
	 * created.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		int[] userArray = getUserArray(console);
		sort(userArray);
		int median = median(userArray);
		int sum = sum(userArray);
		int min = min(userArray);
		int max = max(userArray);
		double mean = mean(userArray);
		System.out.println("The Array has " + + " elements,");
		System.out.println("The minimum is: " + min + " The maximum is: " + max);
		System.out.println("The sum is: " + sum + " the Mean is: " + mean);
		System.out.println("The median is: " + median + " the Mode is + mode);
		System.out.println("Have a great day!");
	}
	
	


	/**
	 * Finds the median of an array of integers.  If the arrays length is even, it returns the average
	 * of the two middle elements. If the array has an odd length, it returns the minimum element.  Note
	 * that this method assumes that the array is already sorted.
	 * @param b The array to find the median of
	 * @return the median of the array (must be a double in case averaging nescessary)
	 */
	private static double median(int[] b) {
		double toReturn = 0;
		if (b.length % 2 == 0){
			int middleIndex1 = b.length / 2 - 1;
			int middleIndex2 = b.length / 2;
			double result = (double) (b[middleIndex1] + b[middleIndex2]) / 2;
			return result;
		} else {
			int middleIndex = b.length / 2;
			double result = b[middleIndex];
			return result;
		}
	}

	/**
	 * Sorts an array of integers in increasing order using a bubble sort algorithm.
	 * does not return a value because arrays are passed by reference, so a change to an
	 * array impacts the array without it being passed back.
	 * @param a An array of integers to sort
	 */
	private static void sort(int[] a) {
		//Uses Bubble Sort to sort the array
		boolean didSwap = false;
		do{
			didSwap = false;
			for(int i = 0; i < a.length - 1; i++){
				//if an element is greater than the one after it, the two are swapped. 
				if(a[i] > a[i+1]){
					int temp = a[i+1];
					a[i+1] = a[i];
					a[i] = temp;
					didSwap = true;
				}
			}	
		} while (didSwap == true);
		//doesn't return the result array, because arrays are passed by reference, so the changes
		//are already impacting userArray in the main method.
	}

	/**
	 * This method asks the user to create an array of integers of the length that they chose.
	 * @param console A scanner object that is used to describe 
	 * @return
	 */
	public static int[] getUserArray(Scanner console){
		System.out.println("How many integers to do you want to enter?");
		//Instantiates the variables size and userArray. User array has <size> elements.
		int size = console.nextInt();
		int[] userArray = new int[size];
		
		//Now has the user enter in their integers, and uses the scanner to place them into
		//the array userArray.
		System.out.println("Now, enter in " + size + " integers, seperated only by a space.");
		int i = 0;
		while (i < size){
			if (console.hasNextInt()){
				userArray[i] = console.nextInt();
				i++;
			} else {
				//If there is no input to read, the program will exit. 
				System.out.println("That is not an integer/Not enough integers provided.");
				return null;
			}
		}
	}
	
	/**
	 * A method that finds the mean of an array a.
	 * @param a the Array to find the mean of
	 * @return the mean of the array.
	 */
	public static double mean(int[] a){
		//uses the sum method to find the total. 
		int total = sum(a);
		double size = a.length;
		double result = total / size;
		return result;	
	}
	
	/**
	 * Finds the minimum of an array of integers a.
	 * @param a The array to find the minimum of
	 * @return the minimum of the array.
	 */
	public static int min(int[] a){
		int minimum = a[0];
		for(int i = 1; i < a.length; i++){
			if (a[i] < minimum){
				minimum = a[i];
			}
		}
		return minimum;
	}
	
	/**
	 * Finds the maximum of an array of integers a.
	 * @param a The array to find the maximum of
	 * @return the maximum of the array.
	 */
	public static int max(int[] a){
		int maximum = a[0];
		for(int i = 1; i < a.length; i++){
			if (a[i] > maximum){
				maximum = a[i];
			}
		}
		return maximum;
	}
	
	/**
	 * Finds the mode of the array that is passed into it. Uses the fact that the array is sorted
	 * in order to find the mode (all elements that are the same will be neighbors), so it counts 
	 * the "streaks" of elements that are the same, and finds the longest streak.
	 * @param c The array of integers to find the mode of
	 * @return the mode of that array
	 */
	public static int mode(int[] c){
		int longestStreak = -1;
		int longStreakOf = -1;
		int currentStreak = 1;
		int currStreakOf = c[0];
		for(int i = 1; i < c.length; i++){
			if (c[i] == c[i-1]){
				currentStreak++;
			} else {
				if (currentStreak > longestStreak){
					longStreakOf = c[i-1];
					longestStreak = currentStreak;
				}
				currentStreak = 1;
				currStreakOf = c[i];
			}
		}
		return longStreakOf;
	}
}
