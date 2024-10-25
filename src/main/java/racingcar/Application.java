package racingcar;

import java.util.List;
import racingcar.input.Input;
import racingcar.validate.RepetitionCountValidator;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = Input.input();
        List<String> cars = Input.splitCar(input);

        String repetition = Input.input();
        RepetitionCountValidator.validateRepetitionCount(repetition);
        int repetitionCount = Integer.parseInt(repetition);

        Input.close();
    }
}
