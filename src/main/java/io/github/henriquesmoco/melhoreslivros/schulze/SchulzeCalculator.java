package io.github.henriquesmoco.melhoreslivros.schulze;

import java.util.Arrays;

public class SchulzeCalculator {

    public boolean[] calculateWinners(int[][] matrix) {
        int[][] strongestPath = calculateStrongestPaph(matrix);
        boolean[] winners = findWinner(strongestPath);
        return winners;
    }
    
    private int[][] calculateStrongestPaph(int[][] d) {
        // Input: d[i,j], the number of voters who prefer candidate i to candidate j.
        //Output: p[i,j], the strength of the strongest path from candidate i to candidate j.

        int candidatesCount = d.length;
        int[][] p = new int[d.length][d.length];
        for (int i = 0; i < candidatesCount; i++) {
            for (int j = 0; j < candidatesCount; j++) {
                if (i != j) {
                    if (d[i][j] > d[j][i]) {
                        p[i][j] = d[i][j];
                    } else {
                        p[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < candidatesCount; i++) {
            for (int j = 0; j < candidatesCount; j++) {
                if (i != j) {
                    for (int k = 0; k < candidatesCount; k++) {
                        if (i != k) {
                            if (j != k) {
                                p[j][k] = Math.max(p[j][k],
                                        Math.min(p[j][i], p[i][k]));
                            }
                        }
                    }
                }
            }
        }
        return p;
    }

    public boolean[] findWinner(int[][] p) {
        int candidatesCount = p.length;
        boolean[] winner = new boolean[candidatesCount];
        Arrays.fill(winner, true);

        for (int i = 0; i < candidatesCount; i++) {
            for (int j = 0; j < candidatesCount; j++) {
                if (i != j) {
                    if (p[j][i] > p[i][j]) {
                        winner[i] = false;
                    }
                }
            }
        }
        return winner;
    }
}
