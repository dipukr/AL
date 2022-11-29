public class Array {
	void reverse(int[] arr) {
		for (int i = 0, j = arr.length - 1; i != j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

	

}
