package algorithms1;

public class SearchInsert {
  public int searchInsert(int[] nums, int target) {
    if(nums[nums.length-1] <= target) {
      return nums.length;
    }

    if(nums[0] >= target) {
      return 0;
    }
    return findSpot(nums, 0, nums.length - 1, target);
  }

  private int findSpot(int[] nums, int start, int end, int target) {
    if(start > end) return -1;
    int middle = start + (end-start)/2;

    if(nums[middle] == target) {
      return middle;
    }

    if(nums[middle] <= target && middle < end && nums[middle+1] > target) {
      return middle + 1;
    }

    if(middle > 0 && nums[middle-1] < target && nums[middle] >= target) {
      return middle;
    }

    if(middle > start && nums[middle-1] < target && nums[middle] >= target) {
      return middle;
    }

    if(nums[middle] > target) {
      return findSpot(nums, start, middle - 1, target);
    }
    return findSpot(nums, middle+1, end, target);
  }
}
