public class Sort {

	public void swap(long[] arr, int i, int j) {
		long temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public void bubbleSort(long[] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr.length - i - 1; j++)
				if (arr[j] > arr[j + 1])
					swap(arr, j, j + 1);
	}

	public void selectionSort(long[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] < arr[min])
					min = j;
			swap(arr, i, min);
		}
	}

	public void insertionSort(long[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int hole = i;
			long elem = arr[i];
			while (hole > 0 && arr[hole - 1] > elem) {
				arr[hole] = arr[hole - 1];
				hole--;
			}
		}
	}

	public void merge(long[] arr, long[] buf, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (arr[i] < arr[j])
				buf[k++] = arr[i++];
			else buf[k++] = arr[j++];
		}
		while (i <= mid)
			buf[k++] = arr[i++];
		while (j <= high)
			buf[k++] = arr[j++];
		for (i = low; i <= high; i++)
			arr[i] = buf[i];
	}

	public void mergeSort(long[] arr, long[] buf, int low, int high) {
		if (low < high) {
			int mid = (low + high) >> 1;
			mergeSort(arr, buf, low, mid);
			mergeSort(arr, buf, mid + 1, high);
			merge(arr, buf, low, mid, high);
		}
	}

	public void mergeSort(long[] arr) {
		var buf = new long[arr.length];
		mergeSort(arr, buf, 0, arr.length - 1);
	}

	public int partition(long[] arr, int low, int high) {
		long pivot = arr[high];
		int p = low;
		for (int i = low; i < high; i++)
			if (arr[i] <= pivot) {
				swap(arr, i, p);
				p++;
			}
		swap(arr, p, high);
		return p;
	}

	public void quickSort(long[] arr, int low, int high) {
		if (low < high) {
			int p = partition(arr, low, high);
			quickSort(arr, low, p - 1);
			quickSort(arr, p + 1, high);
		}
	}
	
	public void quickSort(long[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) throws Exception {
		var arr = new long[]{40,30,50,20,70,10,60};
		var alg = new Sort();
		alg.quickSort(arr);
		for (var elem: arr)
			System.out.print(elem+"\t");
	}
}