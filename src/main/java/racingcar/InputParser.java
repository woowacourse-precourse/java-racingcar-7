package racingcar;

import java.util.List;

public class InputParser {

    public List<Car> parseCarName(String carName) {
        String[] names = carName.split(",");
        GameController gameController = new GameController();
        return gameController.mapToCarArray(names);
    }

    public int parseAttemptNumber(String attemptNumber) {

        if (attemptNumber == null || attemptNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("입력값은 null이거나 빈 문자열일 수 없습니다.");
        }

        try {
            return Integer.parseInt(attemptNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }
}
