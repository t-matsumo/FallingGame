package tetris.field;

import tetris.position.Position;
import tetris.tetriminos.AbstractTetrimino;
import tetris.tetriminos.TTetrimino;

/**
 * Field
 */
public class Field {
  /** フィールドの縦のサイズ */
  private static final int FIELD_HIGHT = 20;
  /** フィールドの横のサイズ */
  private static final int FIELD_WIDTH = 10;
  /** フィールド */
  private int[][] field = new int[FIELD_HIGHT][FIELD_WIDTH];

  /** ゲームオーバーの判定 */
  public Boolean isGameOver(AbstractTetrimino tetrimino) {
    return !tetrimino.canMove(this, 0, 1)  && tetrimino.getPosition().getY() == -1;
  }

  public void fixTetrimino(AbstractTetrimino tetrimino) {
    int[][] shape = tetrimino.getShape();
    Position position = tetrimino.getPosition();

    for (int y = 0; y < shape.length; y++) {
      for (int x = 0; x < shape[y].length; x++) {
        if (shape[y][x] == 1) {
          field[position.getY() + y][position.getX() + x] = shape[y][x];
        }
      }
    }
  }

  public void printOut(AbstractTetrimino tetrimino) {
    int[][] shape = tetrimino.getShape();
    Position position = tetrimino.getPosition();
    System.out.println("\f");
    for (int y = 0; y < field.length; y++) {
      for (int x = 0; x < field[y].length; x++) {
        if (field[y][x] == 1) {
          System.out.print(1);
        // } else if(x == position.getX() && y == position.getY()) {
        } else {
          System.out.print(0);
        }
      }
      System.out.println();
    }
  }

  public int[][] getField() {
    return field;
  }
}