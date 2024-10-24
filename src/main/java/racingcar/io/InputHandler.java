package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public List<String> getCarNames() {
        String carNameString = Console.readLine();
        return extractCarNames(carNameString);
    }

    public int getRound() {
        String roundCountString = Console.readLine();
        return convertToRound(roundCountString);
    }

    private List<String> extractCarNames(String carNamesString) {
        // 자동차 이름에 대한 검증 로직
        if (carNamesString == null) {
            throw new IllegalArgumentException();
        }

        List<String> carNames = Arrays.asList(carNamesString.split(","));

        carNames.stream()
                .filter(carName -> carName.isEmpty() || carName.length() >= 5)
                .findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException();
                });

        return carNames;
    }

    private int convertToRound(String roundString) {
        // 시도할 횟수에 대한 검증 로직
        if (roundString == null) {
            throw new IllegalArgumentException();
        }

        int round = Integer.parseInt(roundString);

        if (round <= 0) {
            throw new IllegalArgumentException();
        }
        return round;
    }
}
