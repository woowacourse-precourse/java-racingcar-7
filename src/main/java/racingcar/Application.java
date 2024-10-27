package racingcar;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser(",", 5);
        InputResult inputResult = inputParser.process();

        System.out.println();

        racingGame game = new racingGame();
        game.run(inputResult);
    }
}