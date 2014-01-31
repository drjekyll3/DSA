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
	}

}
