package racingcar;

public class RacingCar {

    String[] separateCarNames(String inputString) {
        if (!inputString.contains(",")) {
            throw new IllegalArgumentException("구분자가 없습니다.");
        }

        String[] carList = inputString.split(",");

        for (String car : carList) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 5자를 초과합니다.");
            }
        }
        return carList;
    }

    int validateNumberOfAttempts(String inputString) {
        if (!inputString.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("시도할 횟수가 양수가 아닙니다.");
        }
        return Integer.parseInt(inputString);
    }
}
