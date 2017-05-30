package tetris.tetriminos;

import tetris.position.Position;

/**
 * JTetrimino
 */
public class JTetrimino extends AbstractTetrimino {
  /** テトリミノの形 */
  private static final int[][][] J_SHAPES = {
    {
      {0, 0, 0},
      {1, 1, 1},
      {0, 0, 1}
    },
    {
      {0, 1, 1},
      {0, 1, 0},
      {0, 1, 0}
    },
    {
      {0, 0, 0},
      {1, 0, 0},
      {1, 1, 1}
    },
    {
      {0, 1, 0},
      {0, 1, 0},
      {1, 1, 0}
    }
  };

  private static final Position INITIAL_POSITION = new Position(3, -1);
  
  public JTetrimino() {
    super(J_SHAPES, INITIAL_POSITION);
  }
}