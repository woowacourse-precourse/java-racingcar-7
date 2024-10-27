package racingcar.util;

import camp.nextstep.edu.missionutils.Console;

public class RacingCarInput {

    public String[] inputCarNames() {

        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");

        if (CarNameValidator.isEmpty(cars)) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }

        for (String car : cars) {
            if (CarNameValidator.isWithinMaxLength(car)) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }

        return cars;
    }

    public int inputTryCount() {

        System.out.println("시도할 횟수");
        String tryCount = Console.readLine();

        if (!TryCountValidator.isPositiveNumber(tryCount)) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }

        return Integer.parseInt(tryCount);
    }
}
