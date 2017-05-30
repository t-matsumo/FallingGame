package tetris.tetriminos;

import tetris.position.Position;

/**
 * TTetrimino
 */
public class TTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] T_SHAPES = {
    {
      {0, 0, 0},
      {1, 1, 1},
      {0, 1, 0}
    },
    {
      {0, 1, 0},
      {0, 1, 1},
      {0, 1, 0}
    },
    {
      {0, 0, 0},
      {0, 1, 0},
      {1, 1, 1}
    },
    {
      {0, 1, 0},
      {1, 1, 0},
      {0, 1, 0}
    }
  };

  private static final Position INITIAL_POSITION = new Position(3, -1);

  public TTetrimino() {
    super(T_SHAPES, INITIAL_POSITION);
  }
}