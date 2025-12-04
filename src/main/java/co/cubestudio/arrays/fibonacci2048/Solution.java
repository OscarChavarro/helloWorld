package co.cubestudio.arrays.fibonacci2048;

public class Solution {
    public static void main(String[] args) {
        int[][] gameAreaSimple = new int[][] {
                {2, 0, 0, 0},
                {0, 0, 13, 0},
                {0, 0, 0, 0},
                {5, 0, 0, 0}
        };

        int[][] expectedGameAreaLeft = new int[][] {
                {2, 0, 0, 0},
                {13, 0, 0, 0},
                {0, 0, 0, 0},
                {5, 0, 0, 0}
        };

        int[][] expectedGameAreaRight = new int[][] {
                {0, 0, 0, 2},
                {0, 0, 0, 13},
                {0, 0, 0, 0},
                {0, 0, 0, 5}
        };

        int[][] expectedGameAreaUp = new int[][] {
                {2, 0, 13, 0},
                {5, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] expectedGameAreaDown = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
                {5, 0, 13, 0}
        };

        int[][] gameAreaFibonacci = new int[][] {
                {2, 2, 2, 2},
                {0, 1, 0, 2},
                {0, 0, 1, 1},
                {0, 0, 0, 0}
        };

        int[][] expectedGameAreaFibonacci = new int[][] {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 2},
                {2, 3, 3, 3}
        };

        int[][] gameAreaOnesRight = new int[][] {
                {1, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] expectedOnesRight = new int[][] {
                {0, 0, 0, 2},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] gameArea58Right = new int[][] {
                {0, 5, 8, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] expected58Right = new int[][] {
                {0, 0, 0, 13},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] gameArea85Right = new int[][] {
                {0, 8, 5, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] expected85Right = new int[][] {
                {0, 0, 0, 13},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] gameAreaNoDoubleFusion = new int[][] {
                {1, 2, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] expectedNoDoubleFusionRight = new int[][] {
                {0, 0, 1, 5},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] gameAreaRule4Up = new int[][] {
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0}
        };

        int[][] expectedRule4Up = new int[][] {
                {2, 0, 0, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        SolutionTest.test(gameAreaSimple, Direction.RIGHT, expectedGameAreaRight);
        SolutionTest.test(gameAreaSimple, Direction.LEFT, expectedGameAreaLeft);
        SolutionTest.test(gameAreaSimple, Direction.UP, expectedGameAreaUp);
        SolutionTest.test(gameAreaSimple, Direction.DOWN, expectedGameAreaDown);
        SolutionTest.test(gameAreaFibonacci, Direction.DOWN, expectedGameAreaFibonacci);

        SolutionTest.test(gameAreaOnesRight, Direction.RIGHT, expectedOnesRight);
        SolutionTest.test(gameArea58Right, Direction.RIGHT, expected58Right);
        SolutionTest.test(gameArea85Right, Direction.RIGHT, expected85Right);
        SolutionTest.test(gameAreaNoDoubleFusion, Direction.RIGHT, expectedNoDoubleFusionRight);
        SolutionTest.test(gameAreaRule4Up, Direction.UP, expectedRule4Up);
    }
}
