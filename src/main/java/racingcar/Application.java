package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String[] carNames = getCarNames();
    }

    private static String[] getCarNames() {
        System.out.println("자동차 이름을 쉼표로 구분하여 입력하세요.");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }
}
