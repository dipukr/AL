public class Search {

	public boolean linearSearch(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == key)
				return true;
		return false;
	}

	public boolean binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = (low + high) >> 1;
			if (key < arr[mid]) high = mid - 1;
			else if (key > arr[mid]) low = mid + 1;
			return true;
		}
		return false;
	}

	public int lonelySearch(int[] arr) {
		int lonely = 0;
		for (int i = 0; i < arr.length; i++)
			lonely = lonely ^ arr[i];
		return lonely;
	}

	public int findFirstOccurance(int[] arr, int key) {
		int retval = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (key < arr[mid]) high = mid - 1;
			else if (key > arr[mid]) low = mid + 1;
			else {
				retval = mid;
				high = mid - 1;
			} 
		}
		return retval;
	}

	public int findLastOccurance(int[] arr, int key) {
		int retval = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			if (key < arr[mid]) high = mid - 1;
			else if (key > arr[mid]) low = mid + 1;
			else {
				retval = mid;
				low = mid + 1;
			} 
		}
		return retval;
	}

	public int findOccuranceCount(int[] arr, int key) {
		int firstIndex = findFirstOccurance(arr, key);
		int lastIndex = findLastOccurance(arr, key);
		return lastIndex - firstIndex + 1;
	}

	public static void main(String[] args) throws Exception {
		var arr = new int[]{60,20,10,40,30,50,70};
		var ars = new int[]{10,20,30,40,40,60,70};
		var arl = new int[]{20,10,30,10,20,40,30};
		var alg = new Search();
		var val = alg.findOccuranceCount(ars, 40);
		System.out.println(val);
	}
}