package tetris.tetriminos;

import tetris.position.Position;

/**
 * STetrimino
 */
public class STetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] S_SHAPES = {
    {
      {0, 0, 0},
      {0, 1, 1},
      {1, 1, 0}
    },
    {
      {1, 0, 0},
      {1, 1, 0},
      {0, 1, 0}
    }
  };

  private static final Position INITIAL_POSITION = new Position(3, -1);

  public STetrimino() {
    super(S_SHAPES, INITIAL_POSITION);
  }
}