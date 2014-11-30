package io.github.henriquesmoco.melhoreslivros.schulze;

import io.github.henriquesmoco.melhoreslivros.schulze.MatrixBuilder;
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
}
