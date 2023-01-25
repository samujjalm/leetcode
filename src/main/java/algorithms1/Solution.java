package algorithms1;

public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    return findBadVersion(1, n);
  }

  private int findBadVersion(int start, int end) {
    if(start > end) return -1;
    if (start == 1 && end == 1 && isBadVersion(1)) return 1;
    int middle = start + (end-start)/2;

    if(isBadVersion(middle) && middle > 1 && !isBadVersion(middle-1)) {
      return middle;
    }
    if(isBadVersion(middle) && middle == 1) {
      return 1;
    }
    if(!isBadVersion(middle)) {
      return findBadVersion(middle + 1, end);
    }
    return findBadVersion(start, middle-1);
  }


}
