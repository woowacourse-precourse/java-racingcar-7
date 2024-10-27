package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarService;
import racingcar.io.input.Input;
import racingcar.io.output.Output;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Output.playGameInit();
        List<String> carNames = Input.inputCarNames();
        List<Car> cars = CarService.getCars(carNames);

        Output.howManyTry();
        int repetitionCount = Input.inputRepetition();

        Output.executionResult();
        Output.playerResult("pobi", 2);

        Input.close();
    }
}
