package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        input.nameAndCurrentCount();

        Game game = new Game(input.getCarList().split(","), input.getCount());
        game.inputLane();
        game.play();

    }
}
