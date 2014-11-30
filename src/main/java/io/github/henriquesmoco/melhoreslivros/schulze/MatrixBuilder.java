package io.github.henriquesmoco.melhoreslivros.schulze;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class MatrixBuilder {

    private final Map<String, Integer> ballots = new HashMap<>();

    /**
     * Add votes that will compose the matrix of preferred candidates
     *
     * @param voteCount Total votes of this ballot
     * @param orderedCandidates String in the form "Candidate1&gt;Candidate2"
     * where Candidate1 is preferred over Candidate2
     * @return
     */
    public MatrixBuilder addBallot(int voteCount, String orderedCandidates) {
        int totalVotes = voteCount + ballots.getOrDefault(orderedCandidates, 0);
        ballots.put(orderedCandidates, totalVotes);
        return this;
    }

    public int[][] build() {
        List<String> allCandidates = getAllCandidates();
        int[][] matrix = new int[allCandidates.size()][allCandidates.size()];

        for (String orderedBallot : ballots.keySet()) {
            int qtdVotes = ballots.get(orderedBallot);
            String[] splitedCandidates = splitCandidates(orderedBallot);
            addVotesToMatrix(splitedCandidates, allCandidates, matrix, qtdVotes);
        }

        return matrix;
    }

    private void addVotesToMatrix(String[] splitedCandidates, List<String> allCandidates, int[][] matrix, int qtdVotes) {
        for (int idxActual = 0; idxActual < splitedCandidates.length - 1; idxActual++) {
            String actualCandidate = splitedCandidates[idxActual];
            for (int idxNext = idxActual + 1; idxNext < splitedCandidates.length; idxNext++) {
                String nextCandidate = splitedCandidates[idxNext];
                int rowIndex = allCandidates.indexOf(actualCandidate);
                int colIndex = allCandidates.indexOf(nextCandidate);
                int actualVotes = matrix[rowIndex][colIndex];
                matrix[rowIndex][colIndex] = actualVotes + qtdVotes;
            }
        }
    }

    private List<String> getAllCandidates() {
        Set<String> candidates = new HashSet<>();
        for (String orderedBallot : ballots.keySet()) {
            String[] splitCandidates = splitCandidates(orderedBallot);
            candidates.addAll(Arrays.asList(splitCandidates));
        }
        String[] result = candidates.stream().sorted().toArray(String[]::new);
        return Arrays.asList(result);
    }

    private String[] splitCandidates(String orderedBallot) {
        return orderedBallot.split(">");
    }
}
