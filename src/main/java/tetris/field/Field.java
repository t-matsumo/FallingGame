package tetris.field;

import tetris.position.Position;
import tetris.tetriminos.AbstractTetrimino;

/**
 * Field
 */
public class Field {
  /** フィールドの縦のサイズ
   * 可視範囲 + 出現位置の3 マス
   */
  private static final int FIELD_HIGHT = 20 + 3;
  /** フィールドの横のサイズ */
  private static final int FIELD_WIDTH = 10;
  /** フィールド */
  private int[][] field = new int[FIELD_HIGHT][FIELD_WIDTH];

  /** ゲームオーバーの判定 */
  public Boolean isGameOver(AbstractTetrimino tetrimino) {
    return !tetrimino.canMove(field, 0, 1)  && tetrimino.getPosition().getY() == 0;
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
    for (int y = 3; y < field.length; y++) {
      for (int x = 0; x < field[y].length; x++) {
        if (y >= position.getY()
            && y < position.getY() + shape.length
            && x >= position.getX()
            && x < position.getX() + shape[0].length
            && shape[y - position.getY()][x - position.getX()] == 1) {
              System.out.print(shape[y - position.getY()][x - position.getX()]);
        } else {
          System.out.print(field[y][x]);
        }
      }
      System.out.println();
    }
  }

  public int[][] getField() {
    return field;
  }
}