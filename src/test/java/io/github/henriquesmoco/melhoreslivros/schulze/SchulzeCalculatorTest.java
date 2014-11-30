package io.github.henriquesmoco.melhoreslivros.schulze;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class SchulzeCalculatorTest {

    /**
     * @see http://en.wikipedia.org/wiki/Schulze_method
     */
    @Test
    public void calculateWinners_OfMatrixFromWikipedia_GiveTheCorrectWinnerE() {
        int[][] matrix = new int[][]{
            //A, B, C, D, E
            {0, 20, 26, 30, 22}, //A
            {25, 0, 16, 33, 18}, //B
            {19, 29, 0, 17, 24}, //C
            {15, 12, 28, 0, 14}, //D
            {23, 27, 21, 31, 0} //E
        };

        SchulzeCalculator calc = new SchulzeCalculator();
        boolean[] winners = calc.calculateWinners(matrix);

        boolean[] expectedWinnerE = new boolean[]{false, false, false, false, true};
        assertEquals(winners, expectedWinnerE);
    }

}
