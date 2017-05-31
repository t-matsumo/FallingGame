package tetris;

import tetris.field.Field;

import tetris.tetriminos.AbstractTetrimino;
import tetris.tetriminos.TetriminoGenerator;

/**
 * Tetris
 */
public class Main {
  /** mainメソッド */
  public static void main(String[] args) {
    // フィールド
    Field field = new Field();
    // テトリミノ
    AbstractTetrimino tetrimino = TetriminoGenerator.generateTetrimino();
  
    while (!(field.isGameOver(tetrimino))) {
      field.printOut(tetrimino);
      if (tetrimino.canMove(field.getField(), 0, 1)) {
        tetrimino.move(0, 1);
      } else {
        field.fixTetrimino(tetrimino);
        tetrimino = TetriminoGenerator.generateTetrimino();
      }

      try {
        Thread.sleep(250); 
      } catch(Exception e) {
        e.printStackTrace();
      }
    }
  }
}