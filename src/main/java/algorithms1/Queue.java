package algorithms1;

import java.lang.reflect.Array;

public class Queue<T> {
  T[] array;
  int front = -1, rear = -1;
  public Queue(Class<T> clazz, int capacity) {
    array = (T[]) Array.newInstance(clazz, capacity);
  }

  public void addToQueue(T element) {
    if(front < array.length-1) {
      array[++front] = element;
      if(rear == -1) {
        rear = 0;
      }
    }
  }

  public T dequeue() {
    if(rear != -1 && rear <= front) {
      return array[rear++];
    }
    return null;
  }

  public boolean isEmpty() {
    return front == -1 || rear > front;
  }

  public boolean isFull() {
    return front == array.length - 1;
  }
}
