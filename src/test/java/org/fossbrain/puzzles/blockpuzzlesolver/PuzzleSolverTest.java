package org.fossbrain.puzzles.blockpuzzlesolver;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class PuzzleSolverTest {

    @Test
    public void lvlPack1_lvl1_solver() {
        String result = new StringBuilder()
            .append("r g g g \n")
            .append("r y y y \n")
            .append("v v a y \n")
            .append("v a a a \n")
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

        assertEquals(result, baseBoard.printBoard());
    }

    @Test
    public void lvlPack1_lvl2_solver() {
        String result = new StringBuilder()
            .append("r g g g \n")
            .append("r a a a \n")
            .append("v a y y \n")
            .append("v v y y \n")
            .toString();

        Block red = new Block('r', new boolean[][]{ { true }, { true } });
        Block green = new Block('g', new boolean[][]{ { true, true, true } });
        Block violett = new Block('v', new boolean[][]{ { true, false }, { true, true } });
        Block yellow = new Block('y', new boolean[][]{ { true, true }, { true, true } });
        Block amagel = new Block('a', new boolean[][]{ { true, true, true }, { true, false, false } });

        Game baseBoard = new Game().withLenght(4).withHeight(4);
        baseBoard.withBlock(red);
        baseBoard.withBlock(violett);
        baseBoard.withBlock(amagel);
        baseBoard.withBlock(yellow);
        baseBoard.withBlock(green);
        baseBoard.solve();

        assertEquals(result, baseBoard.printBoard());
    }

    @Test
    public void lvlPack2_lvl1_solver() {
        String result = new StringBuilder()
            .append("y y y g g \n")
            .append("a r y y g \n")
            .append("a r r g g \n")
            .append("a a r r v \n")
            .append("a v v v v \n")
            .toString();

        Block red =
            new Block('r', new boolean[][]{ { true, false, false }, { true, true, false }, { false, true, true } });
        Block green = new Block('g', new boolean[][]{ { true, true }, { false, true }, { true, true } });
        Block violett = new Block('v', new boolean[][]{ { false, false, false, true }, { true, true, true, true } });
        Block yellow = new Block('y', new boolean[][]{ { true, true, true, false }, { false, false, true, true } });
        Block amagel =
            new Block('a', new boolean[][]{ { true, false }, { true, false }, { true, true }, { true, false } });

        Game baseBoard = new Game().withLenght(5).withHeight(5);
        baseBoard.withBlock(red);
        baseBoard.withBlock(violett);
        baseBoard.withBlock(amagel);
        baseBoard.withBlock(yellow);
        baseBoard.withBlock(green);
        baseBoard.solve();

        assertEquals(result, baseBoard.printBoard());
    }
}
