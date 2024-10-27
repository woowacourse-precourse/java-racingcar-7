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
        if (carNamesString == null || carNamesString.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        List<String> carNames = Arrays.asList(carNamesString.split(","));

        carNames.stream()
                .filter(carName -> carName.isEmpty() || carName.length() > 5)
                .findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException("올바르지 않은 형식의 값이 존재합니다.");
                });
        return carNames;
    }

    private int convertToRound(String roundString) {
        if (roundString == null || roundString.isEmpty()) {
            throw new IllegalArgumentException("입력 값이 없습니다.");
        }
        int round = Integer.parseInt(roundString);

        if (round <= 0) {
            throw new IllegalArgumentException("라운드 실행 횟수는 0 이상이어야 합니다.");
        }
        return round;
    }
}
