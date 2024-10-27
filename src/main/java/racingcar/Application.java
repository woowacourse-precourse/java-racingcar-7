package racingcar;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser(",", 5);
        InputResult inputResult = inputParser.process();

        System.out.println();

        ConditionConfig condConfig = new ConditionConfig(0, 9, 4);
        racingGame game = new racingGame(condConfig);
        game.run(inputResult);
    }
}