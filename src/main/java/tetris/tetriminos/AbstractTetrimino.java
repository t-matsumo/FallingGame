package tetris.tetriminos;

import java.awt.Shape;

import tetris.field.Field;
import tetris.position.Position;

/**
 * AbstractTetrimino
 */
public abstract class AbstractTetrimino {
  /** テトリミノの形 */
  private int[][][] shapes;
  /** 現在使用中のテトリミノの形のインデックス */
  private int usingShapeIndex = 0;
  /** 位置 */
  private Position position;

  protected AbstractTetrimino(int[][][] shapes, Position position) {
    this.shapes = shapes;
    this.position = position;
  }

  public Boolean canMove(Field field, int deltaX, int deltaY) {
    Position nextPosition = new Position(position.getX() + deltaX, position.getY() + deltaY);
    for (int y = 0; y < shapes[usingShapeIndex].length; y++) {
      for (int x = 0; x < shapes[usingShapeIndex][y].length; x++) {
        if (nextPosition.getY() + y > (field.getField()).length) {
          return false;
        }
        // 移動先が他のブロックとかぶっていない
        if (nextPosition.getY() + y < 0) {
          continue;
        }
        if ((field.getField())[nextPosition.getY() + y][nextPosition.getX() + x] == shapes[usingShapeIndex][y][x]) {
          return false;
        }
      }
    }

    return true;
  }

  public void move(int deltaX, int deltaY) {
    position.setX(position.getX() + deltaX);
    position.setY(position.getY() + deltaY);
  }

  public Boolean canTurn(Field field, int direction) {
    int [][] nextShape = shapes[(usingShapeIndex + direction) % shapes.length];
    for (int y = 0; y < nextShape.length; y++) {
      for (int x = 0; x < nextShape[y].length; x++) {
        if (nextShape[y][x] == 1 && position.getY() + y > (field.getField()).length) {
          return false;
        }
        // 回転先が他のブロックとかぶっていない
        if (position.getY() + y < 0) {
          continue;
        }
        if ((field.getField())[position.getY() + y][position.getX() + x] == nextShape[y][x]) {
          return false;
        }
      }
    }

    return true;
  }

  /** 回転する
   * @param direction 1順回転 -1逆回転
   */
  public void turn(int direction) {
    usingShapeIndex = (usingShapeIndex + direction) % shapes.length;
  }

  public int[][] getShape() {
    return this.shapes[usingShapeIndex];
  }

  public Position getPosition() {
    return this.position;
  }
}