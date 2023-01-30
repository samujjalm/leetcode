package algorithms1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class DeleteIslands {
  static class Coordinate {
    int x;
    int y;

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
  public int[][] removeIslands(int[][] matrix) {
    Set<Coordinate> connectedIslands = new HashSet<>();
    for (int x = 0, y = 0; y < matrix[0].length; y++) {
      dfs(matrix,x,y,connectedIslands);
    }

    for (int x = 0, y=0; x < matrix.length; x++) {
        dfs(matrix,x,y,connectedIslands);

    }

    for (int x = 0, y = matrix[0].length-1; x < matrix.length; x++) {
      dfs(matrix,x,y,connectedIslands);

    }

    for (int x = matrix.length -1,y = 0; x < matrix[0].length; x++) {
        dfs(matrix,x,y,connectedIslands);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if(matrix[i][j] == 1 && !connectedIslands.contains(new Coordinate(i, j))) {
          matrix[i][j] = 0;
        }
      }
    }

    return matrix;
  }

  private void dfs(int[][] matrix, int x, int y, Set<Coordinate> connectedIslands) {
    if(x < 0 || y < 0 || x > matrix.length-1 || y > matrix[0].length-1 || matrix[x][y] == 0 ||
        connectedIslands.contains(new Coordinate(x,y))) {
      return;
    }

    connectedIslands.add(new Coordinate(x,y));
    dfs(matrix,x, y-1, connectedIslands);
    dfs(matrix,x-1, y, connectedIslands);
    dfs(matrix,x, y+1, connectedIslands);
    dfs(matrix,x+1, y, connectedIslands);
  }

  public static void main(String[] args) {
    DeleteIslands deleteIslands = new DeleteIslands();
    int[][] removeIslands = deleteIslands.removeIslands(new int[][] {
        {1,0,0,0,0,0},
        {0,1,0,1,1,1},
        {0,0,1,0,1,0},
        {1,1,0,0,1,0},
        {1,0,1,1,0,0},
        {1,0,0,0,0,1}
    });

    for (int i = 0; i < removeIslands.length; i++) {
      for (int j = 0; j < removeIslands[0].length; j++) {
        System.out.print(removeIslands[i][j]);
      }
      System.out.println();
    }
  }
}
