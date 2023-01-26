package algorithms1;

public class Problem189 {

  public void rotate(int[] nums, int k) {
    k = k%nums.length;
      reverseArr(nums, 0, nums.length-1);
      reverseArr(nums, 0, k-1);
      reverseArr(nums, k, nums.length-1);
    for (int num : nums) {
      System.out.println(num);
    }
  }

  private void reverseArr(int[] nums, int start, int end) {
    while(start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    Problem189 problem189 = new Problem189();
    problem189.rotate(new int[]{1,2,3,4,5,6,7}, 3);
  }

}
