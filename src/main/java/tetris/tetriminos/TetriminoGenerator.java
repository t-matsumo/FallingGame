package tetris.tetriminos;

import java.util.Random;

/**
 * TetriminoGenerator
 */
public class TetriminoGenerator {
  /** テトリミノのリスト */
  private static final AbstractTetrimino[] TETRIMINOS = { new ITetrimino(), new JTetrimino(), new LTetrimino(),
      new OTetrimino(), new STetrimino(), new TTetrimino(), new ZTetrimino() };

  /** tetriminosのサイズ 
   * 乱数の生成に使用
  */
  private static final int TETRIMINOS_LENGTH = TETRIMINOS.length;
  /** 乱数ジェネレータ */
  private static final Random RANDOM = new Random();

  /** テトリミノをランダムに一つ生成して返す */
  public static AbstractTetrimino generateTetrimino() {
    return TETRIMINOS[RANDOM.nextInt(TETRIMINOS_LENGTH)];
  }
}