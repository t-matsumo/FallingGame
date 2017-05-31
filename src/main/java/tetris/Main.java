package tetris;

import java.util.Scanner;

import tetris.field.Field;

import tetris.tetriminos.AbstractTetrimino;
import tetris.tetriminos.TetriminoGenerator;

/**
 * Tetris
 */
public class Main implements Runnable {
  private static Boolean isGaming = true;
  private static int input = 0;

  // フィールド
  private static Field field = new Field();
  // テトリミノ
  private static AbstractTetrimino tetrimino = TetriminoGenerator.generateTetrimino();

  /** mainメソッド */
  public static void main(String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in);

    Thread th = new Thread(new Main());
    th.start();

    while (isGaming) {
      int deltaX;
      int deltaY;
      int direction;
      input = sc.nextInt();
      switch (input) {
        case 1:
          deltaX = -1;
          deltaY = 0;
          move(deltaX, deltaY);
          break;
        case 2:
          deltaX = 0;
          deltaY = 1;
          move(deltaX, deltaY);
          break;
        case 3:
          deltaX = 1;
          deltaY = 0;
          move(deltaX, deltaY);
          break;
        case 4:
          direction = 1;
          turn(direction);
          break;
        case 5:
          direction = -1;
          turn(direction);
          break;
      }
    }

    th.join();
  }

  public static void move(int deltaX, int deltaY) {
    if (tetrimino.canMove(field.getField(), deltaX, deltaY)) {
      tetrimino.move(deltaX, deltaY);
      field.printOut(tetrimino);
    }
  }

  public static void turn(int direction) {
    if (tetrimino.canTurn(field.getField(), direction)) {
      tetrimino.turn(direction);
      field.printOut(tetrimino);
    }
  }

  @Override
  public void run() {
    field = new Field();
    tetrimino = TetriminoGenerator.generateTetrimino();
  
    while (!(field.isGameOver(tetrimino))) {
      field.banish();
      field.printOut(tetrimino);
      if (tetrimino.canMove(field.getField(), 0, 1)) {
        tetrimino.move(0, 1);
      } else {
        field.fixTetrimino(tetrimino);
        tetrimino = TetriminoGenerator.generateTetrimino();
      }

      try {
        Thread.sleep(1000); 
      } catch(InterruptedException e) {
        e.printStackTrace();
      }
    }

    isGaming = false;
  }
}