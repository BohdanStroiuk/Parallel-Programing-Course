package edu.coursera.parallel;

import edu.rice.pcdp.PCDP;

import static edu.rice.pcdp.PCDP.*;

    private MatrixMultiply() {
    }
    public static void seqMatrixMultiply(final double[][] A, final double[][] B,
            final double[][] C, final int N) {
        forseq2d(0, N - 1, 0, N - 1, (i, j) -> {
            C[i][j] = 0.0;
            for (int k = 0; k < N; k++) {
                C[i][j] += A[i][k] * B[k][j];
            }
        });
    }


    public static void parMatrixMultiply(final double[][] A, final double[][] B,
            final double[][] C, final int N) {
      
        forall2dChunked(0, N - 1, 0, N - 1, PCDP.numThreads(), (i, j) -> {
            C[i][j] = 0.0;
            for (int k = 0; k < N; k++) {
                C[i][j] += A[i][k] * B[k][j];
            }
        });
    }
}
