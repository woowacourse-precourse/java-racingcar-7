package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        input.inputNameAndAttemptCount();

        Game game = new Game(input.getCarNameString().split(","), input.getAttemptCount());
        game.carNameValidation();
        game.addArrayToList();
        game.play();

        Output output = new Output(game.carList);
        output.printOutput();

    }
}