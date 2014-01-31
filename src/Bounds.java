public class Bounds {
	private int lowerBound;
	private int upperBound;
	
	/**
	 * Given an int array array, find upper and lower bounds of key.
	 * O(log on) running time.
	 * @param array
	 * @param key
	 */
	public void findBounds(int[] array, int key) {
		lowerBound = -1;
		upperBound = -1;
		findBounds(array, key, 0, array.length - 1);
		System.out.println("The lower bound of " + key + " is " + lowerBound + ".");
		System.out.println("The upper bound of " + key + " is " + upperBound + ".");
		System.out.println();
	}
	
	private void findBounds(int[] array, int key, int start, int end) {
		if (start == end) {
			if (array[start] == key) {
				if (lowerBound == -1) {
					lowerBound = start;
					upperBound = start;
				} else {
					upperBound = start;
				}
			}
		} else {
			int middle = (start + end) / 2;
			findBounds(array, key, start, middle);
			findBounds(array, key, middle + 1, end);
		}
	}
	
	public String stringForm(int[] array) {
		StringBuffer result = new StringBuffer();
		result.append("[");
		int end = array.length - 1;
		for (int i = 0; i < end; i++) {
			result.append(array[i] + ", ");
		}
		result.append(array[end] + "]");
		return result.toString();
	}
	
	public static void main(String[] args) {
		int[] numbers = new int[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 50 + 1);
		}
		Bounds bounds = new Bounds();
		System.out.println(bounds.stringForm(numbers));
		bounds.findBounds(numbers, 11);
		bounds.findBounds(numbers, 4);
		bounds.findBounds(numbers, 9);
		bounds.findBounds(numbers, 50);
		bounds.findBounds(numbers, 34);
		bounds.findBounds(numbers, 23);
		bounds.findBounds(numbers, 98);
		bounds.findBounds(numbers, 8);
		
		
		/**		
 		[40, 14, 25, 25, 29, 17, 13, 44, 36, 5, 21, 41, 6, 19, 2, 16, 19, 19, 40, 42, 47, 32, 30, 4, 10, 27, 41, 7, 38, 13, 3, 43, 8, 9, 37, 19, 18, 6, 13, 11, 20, 1, 10, 33, 47, 20, 37, 31, 6, 18, 6, 36, 14, 20, 3, 2, 30, 12, 15, 28, 3, 28, 47, 4, 18, 11, 43, 25, 8, 32, 21, 31, 30, 2, 25, 27, 24, 5, 46, 5, 31, 35, 3, 32, 46, 19, 3, 2, 1, 44, 24, 12, 15, 7, 28, 27, 16, 31, 41, 12]
		The lower bound of 11 is 39.
		The upper bound of 11 is 65.

		The lower bound of 4 is 23.
		The upper bound of 4 is 63.

		The lower bound of 9 is 33.
		The upper bound of 9 is 33.

		The lower bound of 50 is -1.
		The upper bound of 50 is -1.

		The lower bound of 34 is -1.
		The upper bound of 34 is -1.

		The lower bound of 23 is -1.
		The upper bound of 23 is -1.

		The lower bound of 98 is -1.
		The upper bound of 98 is -1.

		The lower bound of 8 is 32.
		The upper bound of 8 is 68.
		**/	
	}

}
