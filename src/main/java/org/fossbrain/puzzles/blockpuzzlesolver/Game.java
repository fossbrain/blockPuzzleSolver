package org.fossbrain.puzzles.blockpuzzlesolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description of the board the game is played on
 */
public class Game {

    private int lenght;
    private int height;
    private List<Block> blocks = new ArrayList<Block>();
    private char[][] board;

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
        sortBlocksAccordingToTheirPossibleStartPositions();
        initializeBoard();
        System.out.println(printBoard());
        return this;
    }

    private void initializeBoard() {
        board = new char[height][lenght];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < lenght; x++) {
                board[y][x] = '0';
            }
        }
    }

    private void sortBlocksAccordingToTheirPossibleStartPositions() {
        Collections.sort(blocks);
    }

    private void calculatePossibleBlockStartPositions() {
        for (Block block : blocks) {
            block.calculatePossiblePositions(lenght, height);
        }
    }

    public String printBoard() {
        StringBuilder currentSate = new StringBuilder();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < lenght; x++) {
                currentSate.append(board[y][x]).append(" ");
            }
            currentSate.append("\n");
        }
        return currentSate.toString();
    }

}
