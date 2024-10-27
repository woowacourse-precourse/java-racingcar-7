package racingcar;

import java.util.List;
import racingcar.car.Car;
import racingcar.car.CarService;
import racingcar.io.input.Input;
import racingcar.io.output.OutputMessage;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(OutputMessage.PLAY_GAME_DESCRIPTION.getMessage());
        List<String> carNames = Input.inputCarNames();
        List<Car> cars = CarService.getCars(carNames);

        System.out.println(OutputMessage.HOW_MANY_TRY.getMessage());
        int repetitionCount = Input.inputRepetition();

        System.out.println(OutputMessage.EXECUTION_RESULT.getMessage());

        Input.close();
    }
}
