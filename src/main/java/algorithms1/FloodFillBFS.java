package algorithms1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class FloodFillBFS {

  class Coordinate {
    public final int x;
    public final int y;

    public Coordinate(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Coordinate that = (Coordinate) o;
      return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    Queue<Coordinate> queue = new Queue<>(Coordinate.class, image.length * image[0].length);
    Set<Coordinate> visitedNodes = new HashSet<>();
    int targetValue = image[sr][sc];
    Coordinate start = new Coordinate(sr, sc);
    queue.addToQueue(start);
    visitedNodes.add(start);

    while (!queue.isEmpty()) {
      Coordinate coordinate = queue.dequeue();
      if(coordinate.x > 0 && image[coordinate.x-1][coordinate.y] == targetValue) {
        Coordinate up = new Coordinate(coordinate.x-1, coordinate.y);
        if(!visitedNodes.contains(up)) {
          queue.addToQueue(up);
          visitedNodes.add(up);
        }
      }

      if(coordinate.y > 0 && image[coordinate.x][coordinate.y-1] == targetValue) {
        Coordinate left = new Coordinate(coordinate.x, coordinate.y-1);
        if(!visitedNodes.contains(left)) {
          queue.addToQueue(left);
          visitedNodes.add(left);
        }
      }

      if(coordinate.x < image.length-1 && image[coordinate.x+1][coordinate.y] == targetValue) {
        Coordinate down = new Coordinate(coordinate.x+1, coordinate.y);
        if(!visitedNodes.contains(down)) {
          queue.addToQueue(down);
          visitedNodes.add(down);
        }
      }

      if(coordinate.y < image[0].length-1 && image[coordinate.x][coordinate.y+1] == targetValue) {
        Coordinate right = new Coordinate(coordinate.x, coordinate.y+1);
        if(!visitedNodes.contains(right)) {
          queue.addToQueue(right);
          visitedNodes.add(right);
        }
      }
    }

    for (Coordinate coordinate :
        visitedNodes) {
      image[coordinate.x][coordinate.y] = color;
    }

    return image;
  }

  public static void main(String[] args) {
    FloodFillBFS floodFillBFS = new FloodFillBFS();
    int[][] fill = floodFillBFS.floodFill(new int[][] {
        {0,0,0},
        {0,1,0}}, 1, 0, 2);

    for (int i = 0; i < fill.length; i++) {
      for (int j = 0; j < fill[0].length; j++) {
        System.out.printf("%d, ", fill[i][j]);
      }
      System.out.println();
    }
  }
}
