package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carList = Console.readLine().replaceAll(" ", "");

        String[] cars = carList.split(",");
        validateCarNames(cars);

        return cars;
    }

    public int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCount = Console.readLine().replaceAll(" ", "");

        return validateTryCount(tryCount);
    }

    private void validateCarNames(String[] cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
        }
    }

    private int validateTryCount(String tryCount) {
        try {
            return Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
