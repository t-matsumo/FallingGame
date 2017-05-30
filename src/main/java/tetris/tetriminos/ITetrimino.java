package tetris.tetriminos;

import tetris.position.Position;

/**
 * ITetrimino
 */
public class ITetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] I_SHAPES = {
    {
      {0, 0, 0, 0},
      {1, 1, 1, 1},
      {0, 0, 0, 0},
      {0, 0, 0, 0}
    },
    {
      {0, 0, 1, 0},
      {0, 0, 1, 0},
      {0, 0, 1, 0},
      {0, 0, 1, 0}
    }
  };

  private static final Position INITIAL_POSITION = new Position(3, -1);

  public ITetrimino() {
    super(I_SHAPES, INITIAL_POSITION);
  }
}