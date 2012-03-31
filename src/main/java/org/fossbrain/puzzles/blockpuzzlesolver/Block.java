package org.fossbrain.puzzles.blockpuzzlesolver;

import java.util.List;

public class Block {

    private char representation;
    private boolean[][] layout;
    private List<Integer> possibleStartLocations;

    public Block(char representation, boolean[][] layout) {
        this.representation = representation;
        this.layout = layout;
    }
}
