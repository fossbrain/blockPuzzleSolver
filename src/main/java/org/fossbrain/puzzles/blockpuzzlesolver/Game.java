package org.fossbrain.puzzles.blockpuzzlesolver;

/**
 * Description of the board the game is played on
 */
public class Game {

    private int lenght;
    private int height;

    public Game(int lenght, int height) {
        this.lenght = lenght;
        this.height = height;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
