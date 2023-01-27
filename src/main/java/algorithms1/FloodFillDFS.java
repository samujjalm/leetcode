package algorithms1;

public class FloodFillDFS {

  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if(image[sr][sc] == color) return image;
    fill(image, sr, sc, color, image[sr][sc]);
    return image;
  }

  private void fill(int[][] image, int sr, int sc, int color, int originalValue) {
    if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originalValue) {
      return;
    }
    image[sr][sc] = color;
    fill(image, sr+1, sc, color, originalValue);
    fill(image, sr, sc+1, color, originalValue);
    fill(image, sr-1, sc, color, originalValue);
    fill(image, sr, sc-1, color, originalValue);
  }

  public static void main(String[] args) {
    FloodFillDFS floodFillDFS = new FloodFillDFS();
    int[][] fill = floodFillDFS.floodFill(new int[][] {
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
