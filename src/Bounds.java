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
		[47, 33, 14, 14, 35, 26, 13, 10, 39, 49, 20, 20, 40, 48, 10, 8, 41, 3, 50, 47, 50, 42, 47, 50, 29, 5, 5, 26, 25, 6, 19, 43, 32, 24, 13, 42, 26, 6, 42, 29, 19, 23, 24, 38, 16, 21, 6, 34, 23, 1, 1, 16, 11, 15, 37, 40, 41, 22, 42, 25, 39, 41, 24, 50, 9, 15, 10, 32, 5, 2, 22, 22, 9, 44, 37, 3, 40, 41, 26, 42, 41, 25, 5, 17, 50, 16, 8, 15, 37, 48, 38, 10, 24, 8, 28, 30, 27, 48, 47, 40]
		The lower bound of 11 is 52.
		The upper bound of 11 is 52.

		The lower bound of 4 is -1.
		The upper bound of 4 is -1.

		The lower bound of 9 is 64.
		The upper bound of 9 is 72.

		The lower bound of 50 is 18.
		The upper bound of 50 is 84.

		The lower bound of 34 is 47.
		The upper bound of 34 is 47.

		The lower bound of 23 is 41.
		The upper bound of 23 is 48.

		The lower bound of 98 is -1.
		The upper bound of 98 is -1.

		The lower bound of 8 is 15.
		The upper bound of 8 is 93.
		**/
	}

}
