package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarRacing carRacing = new CarRacing();
        List<String> carNames = carRacing.getCarNames();
        int attempts = carRacing.getRaceAttempts();
        carRacing.validateCarNames(carNames);

    }
}
