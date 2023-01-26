package algorithms1;

public class Problem283 {

  public void moveZeroes(int[] nums) {
    if(nums.length <= 1) return;
    int left = 0;
    int right = 1;

    while(right < nums.length) {
      if (nums[left] != 0) {
        left++;
        right++;
      }
      else if(nums[left] == 0 && nums[right] != 0) {
          nums[left] = nums[right];
          nums[right] = 0;
          left++;
          right++;
      } else if (nums[right] == 0) {
        right++;
      }
    }

    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }

  public static void main(String[] args) {
    Problem283 problem283 = new Problem283();
    problem283.moveZeroes(new int[]{2,1});
  }
}
