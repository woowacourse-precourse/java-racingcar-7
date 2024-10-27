package racingcar;

public class GameController {
    public final InputView input;
    public final OutputView output;
    public final Car car;

    public GameController(InputView input, OutputView output, Car car) {
        this.input = input;
        this.output = output;
        this.car = car;
    }

//    public void setCarName() {
//        input.printStart();
//        List<String> carNames = input.printStart();
//        car.setCarName(String.valueOf(carNames));
//    }

    public void getResult() {

    }
}
