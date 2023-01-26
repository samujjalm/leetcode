package algorithms1;


public class Problem997 {

  static class Heap {
    int insertIndex = 0;

    int[] heap;

    public Heap(int size) {
      heap = new int[size];
    }

    void addToHeap(int number) {
        if(insertIndex > heap.length) {
          return;
        }
        heap[insertIndex++] = number;
    }
    
    void maxHeapifyDown() {
      for (int i = 0; i < (heap.length-1)/2; i++) {
        maxHeapifyDown(i, heap.length-1);
      }
    }

    public int[] getHeap() {
      return heap;
    }

    public int getCurrentIndex() {
      return insertIndex-1;
    }

    private void maxHeapifyDown(int i, int lastIndex) {
      int left = 2*i + 1;
      int right = 2*i + 2;
      int higherValueIndex = i;

      if(left <= lastIndex && heap[higherValueIndex] < heap[left]) {
        higherValueIndex = left;
      }

      if (right <= lastIndex && heap[higherValueIndex] < heap[right]) {
        higherValueIndex = right;
      }

      if(higherValueIndex != i) {
        int temp = heap[higherValueIndex];
        heap[higherValueIndex] = heap[i];
        heap[i] = temp;
        maxHeapifyDown(higherValueIndex, lastIndex);
      }
    }

    public void heapifyUp(int currentIndex) {
      if (currentIndex <= 0) return;
      int parent = (currentIndex-1)/2;
      if(heap[currentIndex] > heap[parent]) {
        int temp = heap[currentIndex];
        heap[currentIndex] = heap[parent];
        heap[parent] = temp;
        heapifyUp(parent);
      }
    }
  }
  public static int[] sortedSquares(int[] nums) {
    Heap maxHeap = new Heap(nums.length);
    for (int num : nums) {
      maxHeap.addToHeap(num * num);
      maxHeap.heapifyUp(maxHeap.getCurrentIndex());
    }
    maxHeap.maxHeapifyDown();
    return heapSort(maxHeap);

  }

  private static int[] heapSort(Heap heap) {
    int lastIndex = heap.getHeap().length - 1;
    while(0 < lastIndex) {
      int lastValue = heap.heap[lastIndex];
      heap.heap[lastIndex] = heap.heap[0];
      heap.heap[0] = lastValue;
      lastIndex--;
      heap.maxHeapifyDown(0,lastIndex);
    }
    return heap.getHeap();

  }

  public static void main(String[] args) {
    int[] ints = Problem997.sortedSquares(new int[] {-9,-7,-5,-3,-1,2,4,4,7,10});
    for (int anInt : ints) {
      System.out.println(anInt);
    }
  }
}
