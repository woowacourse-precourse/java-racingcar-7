package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String[] carNames = getCarNames();
    }

    private static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    // 자동차 이름 유효성 검사
    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (isInvalidCarName(name)) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 설정해야 합니다.");
            }
        }
    }

    private static boolean isInvalidCarName(String name) {
        return name.trim().length() > 5 || name.trim().isEmpty();
    }
}
