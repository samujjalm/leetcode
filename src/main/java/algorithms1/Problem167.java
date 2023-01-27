package algorithms1;

import java.util.Map;

public class Problem167 {
  public int[] twoSum(int[] numbers, int target) {
    int[] result = new int[2];
    int left = 0, right = numbers.length - 1;
    while (left < right) {
      if(numbers[left] + numbers[right] == target) {
        result[0] = left + 1;
        result[1] = right + 1;
        break;
      } else if (numbers[left] + numbers[right] < target) {
        left++;
      } else {
        right--;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Problem167 problem167 = new Problem167();
    int[] result = problem167.twoSum(new int[] {2, 7, 11, 15}, 9);
    for (int i : result) {
      System.out.println(i);
    }
  }
}
