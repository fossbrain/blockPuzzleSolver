package org.fossbrain.puzzles.blockpuzzlesolver;

import java.util.ArrayList;
import java.util.List;

public class Position {

    private int startX;
    private int startY;
    private Block block;

    List<OriginalValue> originalValues;

    public Position(int x, int y, Block block) {
        startX = x;
        startY = y;
        this.block = block;
    }

    boolean apply(char[][] board) {
        originalValues = new ArrayList<Position.OriginalValue>();
        for (int y = 0; y < block.getLayout().length; y++) {
            for (int x = 0; x < block.getLayout()[0].length; x++) {
                if (board[startY + y][startX + x] != '0' && block.getLayout()[y][x]) {
                    return false;
                }
                if (block.getLayout()[y][x]) {
                    board[startY + y][startX + x] = block.getRepresentation();
                    originalValues.add(new OriginalValue(startX + x, startY + y));
                }
            }
        }
        return true;
    }

    void revert(char[][] board) {
        for (OriginalValue originalValue : originalValues) {
            board[originalValue.y][originalValue.x] = '0';
        }
    }

    private class OriginalValue {
        private int x;
        private int y;

        public OriginalValue(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
