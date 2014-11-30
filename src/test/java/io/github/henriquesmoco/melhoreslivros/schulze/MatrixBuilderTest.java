package io.github.henriquesmoco.melhoreslivros.schulze;

import java.util.Arrays;
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
        System.out.println(Arrays.deepToString(matrix));
        assertEquals(matrix, expectedMatrix);
    }
}
