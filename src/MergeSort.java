
public class MergeSort {
	public void mergeSort(int[] array) {
		mergeSort(array, 0, array.length - 1);
	}
	
	private void mergeSort(int[] array, int left, int right) {
		if (left != right) {
			int mid = (left + right) / 2;
			mergeSort(array, left, mid);
			mergeSort(array, mid + 1, right);
			merge(array, left, right, mid);
		}
	}
	
	private void merge(int[] array, int left, int right, int mid) {
		System.out.println("left:     " + left);
		System.out.println("right:    " + right);
		System.out.println("mid:      " + mid);
		
		int nL = mid - left + 1;
		int nR = right - mid;
		int[] L = new int[nL];
		int[] R = new int[nR];
		
		int g = 0;
		int h = 0;
		for (g = left; g <= mid; g ++) {
			L[h++] = array[g];
		}
		
		h = 0;
		for (g = mid + 1; g <= right; g++) {
			R[h++] = array[g];
		}

		System.out.println("nL:       " + nL);
		System.out.println("nR:       " + nR);
		
		System.out.println("L:        " + stringForm(L));
		System.out.println("R:        " + stringForm(R));
		int k = left;
		int i = 0;
		int j = 0;
		while (i < nL && j < nR) {
			if (L[i] > R[j]) {
				array[k] = R[j++];
			} else {
				array[k] = L[i++];
			}
			k++;
		}
		
		while (i < nL) {
			array[k++] = L[i++]; 
		}
		
		while (j < nR) {
			array[k++] = R[j++];
		}
		System.out.println("---------------------------------------------------------------------------");
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
		int[] numbers = new int[15];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int)(Math.random() * 50 + 1);
		}
		
		MergeSort mS = new MergeSort();
		System.out.println("Unsorted: " + mS.stringForm(numbers));
		System.out.println();
		mS.mergeSort(numbers);
		System.out.println("Sorted:   " + mS.stringForm(numbers));
		System.out.println();

	}

}
