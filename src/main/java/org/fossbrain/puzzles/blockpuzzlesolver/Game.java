package org.fossbrain.puzzles.blockpuzzlesolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Description of the board the game is played on
 */
public class Game {

    private int lenght;
    private int height;
    private List<Block> blocks = new ArrayList<Block>();

    public Game() {
    }

    public Game withHeight(int height) {
        this.height = height;
        return this;
    }

    public Game withLenght(int lenght) {
        this.lenght = lenght;
        return this;
    }

    public Game withBlock(Block block) {
        blocks.add(block);
        return this;
    }

    public Game solve() {
        calculatePossibleBlockStartPositions();
        return this;
    }

    private void calculatePossibleBlockStartPositions() {
        for (Block block : blocks) {
            block.calculatePossiblePositions(lenght,height);
        }
    }

    public String printBoard() {
        return "";
    }

}
