package org.fossbrain.puzzles.blockpuzzlesolver;

import java.util.ArrayList;
import java.util.List;

public class Block implements Comparable<Block> {

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

    public List<Position> getStartPositions() {
        return possibleStartLocations;
    }

    public char getRepresentation() {
        return representation;
    }

    public boolean[][] getLayout() {
        return layout;
    }

    public void calculatePossiblePositions(int lenght, int height) {
        calculateHeighestPossibilities(height);
        calculateLenghtPossibilities(lenght);
        for (int x = 0; x < lenghtPossibilities; x++) {
            for (int y = 0; y < heightPossibilities; y++) {
                possibleStartLocations.add(new Position(x, y, this));
            }
        }
    }

    private void calculateHeighestPossibilities(int height) {
        heightPossibilities = height + 1 - layout.length;
    }

    private void calculateLenghtPossibilities(int lenght) {
        lenghtPossibilities = lenght + 1 - layout[0].length;
    }

    public int compareTo(Block o) {
        return getPossibleStartLocations() - o.getPossibleStartLocations();
    }

}
