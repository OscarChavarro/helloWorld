package co.cubestudio.arrays.fibonacci2048;

final class SolutionTest {
    private SolutionTest() {
    }

    static void test(int[][] gameArea, Direction push, int[][] expectedGameArea) {
        // Arrange
        System.out.println("= Test for push " + push.name() + " ==============");
        The2048Bonacci game = new The2048Bonacci(gameArea);
        The2048Bonacci expectedGame = new The2048Bonacci(expectedGameArea);
        The2048Bonacci gameCopy = new The2048Bonacci(game);

        // Action
        Mover solver = new Mover();
        solver.playStep(gameCopy, push);

        // Assert
        if (gameCopy.equals(expectedGame)) {
            System.out.println(" - Test passed");
        } else {
            System.out.println(" - Test FAILED");
            System.out.println("Before: ");
            System.out.println(game.getDescription());
            System.out.println("After: ");
            System.out.println(gameCopy.getDescription());
            System.out.println("Expected: ");
            System.out.println(expectedGame.getDescription());
        }
    }
}
