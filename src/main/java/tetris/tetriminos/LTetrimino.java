package tetris.tetriminos;

import tetris.position.Position;

/**
 * LTetrimino
 */
public class LTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] L_SHAPES = {
    {
      {0, 0, 0},
      {1, 1, 1},
      {1, 0, 0}
    },
    {
      {0, 1, 0},
      {0, 1, 0},
      {0, 1, 1}
    },
    {
      {0, 0, 0},
      {0, 0, 1},
      {1, 1, 1}
    },
    {
      {1, 1, 0},
      {0, 1, 0},
      {0, 1, 0}
    }
  };

  private static final Position INITIAL_POSITION = new Position(3, -1);

  public LTetrimino() {
    super(L_SHAPES, INITIAL_POSITION);
  }
}