public class Djk {

  int n = 5;
  int [][] MatrixWeight = {
          {999,10,999,999,999},
          {10,999,12,6,8},
          {999,12,999,8,999},
          {999,6,8,999,3},
          {999,8,999,3,999}
  };
  int [][] MatrixHistory = {
          {0,1,0,0,0},
          {0,1,2,3,4},
          {2,1,2,3,2},
          {3,1,2,3,4},
          {4,1,4,3,4}
  };

  public void getPath(int first, int second)
  {
    if (MatrixWeight[first][second] == 999) {
      System.out.println("Нет пути");
      return;
    }

    int c = first;
    while (c != second) {
      System.out.print(c + " ");
      c = MatrixHistory[c][second];
    }
    System.out.print(second);
  }

  public void show()
  {
    System.out.println();
    System.out.println();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%4d", MatrixWeight[i][j]);
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.printf("%3d", MatrixHistory[i][j]);
      }
      System.out.println();
    }
  }

  public void algo()
  {
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        if (MatrixWeight[i][k] != 999) {
          for (int j = 0; j < n; j++) {
            if (i != j) {
              if (MatrixWeight[i][j] > MatrixWeight[i][k] + MatrixWeight[k][j]) {
                MatrixWeight[i][j] = MatrixWeight[i][k] + MatrixWeight[k][j];
                MatrixHistory[i][j] = MatrixHistory[i][k];
              }
            }
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    Djk graph = new Djk();
    graph.show();
    graph.algo();
    graph.show();
    System.out.println();
    graph.getPath(0 , 3);
  }
}
