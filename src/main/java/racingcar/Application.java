package racingcar;

import java.util.List;
import racingcar.input.Input;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = Input.inputCarNames();
        int repetitionCount = Input.inputRepetition();

        Input.close();
    }
}
