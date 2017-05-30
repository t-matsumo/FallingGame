package tetris.tetriminos;

import tetris.position.Position;

/**
 * ZTetrimino
 */
public class ZTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] Z_SHAPES = {
    {
      {0, 0, 0},
      {1, 1, 0},
      {0, 1, 1}
    },
    {
      {0, 0, 1},
      {0, 1, 1},
      {0, 1, 0}
    }
  };

  private static final Position INITIAL_POSITION = new Position(3, -1);

  public ZTetrimino() {
    super(Z_SHAPES, INITIAL_POSITION);
  }
}