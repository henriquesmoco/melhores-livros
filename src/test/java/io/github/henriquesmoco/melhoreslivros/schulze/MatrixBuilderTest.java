package io.github.henriquesmoco.melhoreslivros.schulze;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class MatrixBuilderTest {

    @Test
    public void buildMatrix_OfOneOrderedBallot_CreateMatrixCorrectly() {
        MatrixBuilder matrixBuilder = new MatrixBuilder();
        int[][] expectedMatrix = new int[][]{
            //A, B, C
            {0, 1, 1}, //A
            {0, 0, 1}, //B
            {0, 0, 0} //C
        };
        int[][] matrix = matrixBuilder.addBallot(1, "A>B>C").build();
        assertEquals(matrix, expectedMatrix);
    }

    @Test
    public void buildMatrix_OfTwoEqualsOrderedBallots_CreateMatrixWithSumOfTheVotes() {
        MatrixBuilder matrixBuilder = new MatrixBuilder();
        int[][] expectedMatrix = new int[][]{
            //A, B, C
            {0, 2, 2}, //A
            {0, 0, 2}, //B
            {0, 0, 0} //C
        };
        int[][] matrix = matrixBuilder
                .addBallot(1, "A>B>C")
                .addBallot(1, "A>B>C")
                .build();
        assertEquals(matrix, expectedMatrix);
    }
    
    @Test
    public void buildMatrix_OfUnorderedBallots_CreateMatrixWithSumOfTheVotes() {
        MatrixBuilder matrixBuilder = new MatrixBuilder();
        int[][] expectedMatrix = new int[][]{
            //X, Y, Z
            {0, 4, 1}, //X
            {2, 0, 3}, //Y
            {5, 3, 0} //Z
        };
        int[][] matrix = matrixBuilder
                .addBallot(1, "X>Y>Z")
                .addBallot(2, "Y>Z>X")
                .addBallot(3, "Z>X>Y")
                .build();
        //System.out.println(Arrays.deepToString(matrix));
        assertEquals(matrix, expectedMatrix);
    }
    
    /**
     * @see http://en.wikipedia.org/wiki/Schulze_method
     */
    @Test
    public void buildMatrix_OfBallotsFromWikipedia_CreateMatrixCorrectly() {
        MatrixBuilder matrixBuilder = new MatrixBuilder();
        int[][] expectedMatrix = new int[][]{
            //A, B, C, D, E
            {0, 20, 26, 30, 22}, //A
            {25, 0, 16, 33, 18}, //B
            {19, 29, 0, 17, 24}, //C
            {15, 12, 28, 0, 14}, //D
            {23, 27, 21, 31, 0} //E

        };
        
        int[][] matrix = matrixBuilder
                .addBallot(5, "A>C>B>E>D")
                .addBallot(5, "A>D>E>C>B")
                .addBallot(8, "B>E>D>A>C")
                .addBallot(3, "C>A>B>E>D")
                .addBallot(7, "C>A>E>B>D")
                .addBallot(2, "C>B>A>D>E")
                .addBallot(7, "D>C>E>B>A")
                .addBallot(8, "E>B>A>D>C")
                .build();
        //System.out.println(Arrays.deepToString(matrix));
        assertEquals(matrix, expectedMatrix);
    }

}
