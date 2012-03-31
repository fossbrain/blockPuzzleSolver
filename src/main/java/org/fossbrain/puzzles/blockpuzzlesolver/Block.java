package org.fossbrain.puzzles.blockpuzzlesolver;

import java.util.ArrayList;
import java.util.List;

public class Block {

    private char representation;
    private boolean[][] layout;
    private List<Position> possibleStartLocations = new ArrayList<Position>();

    private int heightPossibilities;
    private int lenghtPossibilities;

    public Block(char representation, boolean[][] layout) {
        this.representation = representation;
        this.layout = layout;
    }

    public int getPossibleStartLocations() {
        return possibleStartLocations.size();
    }

    public void calculatePossiblePositions(int lenght, int height) {
        calculateHeighestPossibilities(height);
        calculateLenghtPossibilities(lenght);
        for (int x = 0; x < lenghtPossibilities; x++) {
            for (int y = 0; y < heightPossibilities; y++) {
                possibleStartLocations.add(new Position(x, y));
            }
        }
    }

    private void calculateHeighestPossibilities(int height) {
        heightPossibilities = height + 1 - layout.length;
    }

    private void calculateLenghtPossibilities(int lenght) {
        int heighest = calculateHeighestElement();
        lenghtPossibilities = lenght + 1 - heighest;
    }

    private int calculateHeighestElement() {
        int heighest = 0;
        for (boolean[] position : layout) {
            if (position.length > heighest) {
                heighest = position.length;
            }
        }
        return heighest;
    }
}
