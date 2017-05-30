package tetris.tetriminos;

import tetris.position.Position;

/**
 * OTetrimino
 */
public class OTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] O_SHAPES = {
    {
      {0, 0, 0},
      {0, 1, 1},
      {0, 1, 1}
    },
    {
      {0, 0, 0},
      {0, 1, 1},
      {0, 1, 1}
    }
  };

  private static final Position INITIAL_POSITION = new Position(3, -1);

  public OTetrimino() {
    super(O_SHAPES, INITIAL_POSITION);
  }
}