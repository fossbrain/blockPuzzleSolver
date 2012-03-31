package org.fossbrain.puzzles.blockpuzzlesolver;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class PuzzleSolverTest {

    @Test
    public void lvl1_solver() {
        String result = new StringBuilder()
            .append("r g g g\n")
            .append("r y y y\n")
            .append("v v a y\n")
            .append("v a a a\n")
            .toString();

        Block red = new Block('r', new boolean[][]{ { true }, { true } });
        Block violett = new Block('v', new boolean[][]{ { true, true }, { true, false } });
        Block amagel = new Block('a', new boolean[][]{ { false, true, false }, { true, true, true } });
        Block yellow = new Block('y', new boolean[][]{ { true, true, true }, { false, false, true } });
        Block green = new Block('g', new boolean[][]{ { true, true, true } });

        Game baseBoard = new Game().withLenght(4).withHeight(4);
        baseBoard.withBlock(red);
        baseBoard.withBlock(violett);
        baseBoard.withBlock(amagel);
        baseBoard.withBlock(yellow);
        baseBoard.withBlock(green);
        baseBoard.solve();

        assertEquals(12, red.getPossibleStartLocations());
        assertEquals(9, violett.getPossibleStartLocations());
        assertEquals(6, amagel.getPossibleStartLocations());
        assertEquals(6, yellow.getPossibleStartLocations());
        assertEquals(8, green.getPossibleStartLocations());

        // assertEquals(result, baseBoard.printBoard());
    }

}
