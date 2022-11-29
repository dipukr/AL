import java.util.Arrays;

public class Miss {
	public int findMissingNumber(Integer[] nums) {
		boolean[] exist = new boolean[nums.length + 1];
		Arrays.fill(exist, false);
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != null)
				exist[nums[i]] = true;
		for (int i = 1; i < exist.length; i++)
			if (exist[i] == false)
				return i;
		return -1;
	}

	public static void main(String[] args) {
		var miss = new Miss();
		Integer[] nums = new Integer[]{8,6,7,5,null,4,1,3,2,10};
		System.out.println(Arrays.toString(nums));
		System.out.printf("%d is missing number", miss.findMissingNumber(nums));
	}
}