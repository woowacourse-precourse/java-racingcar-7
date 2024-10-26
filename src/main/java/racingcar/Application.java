package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // pobi,woni,jun
        Input input = new Input();
        input.nameAndCurrentCount();

        Game game = new Game(input.getCarList().split(","), input.getCount());
        game.inputLane();
        game.play();

        Output output = new Output(game.carList);
        output.printOutput();

    }
}