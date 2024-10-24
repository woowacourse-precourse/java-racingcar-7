package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNames = readCarNames();
        String tryCount = readTryCount();

        validateCarNames(carNames);
        validateTryCount(tryCount);
    }

    static void validateCarNames(String carNames) {
        checkNameExist(carNames);
        for (String carName : carNames.split(",")) {
            String stripCarName = carName.strip();
            checkEmptyName(stripCarName);
            checkCarNameLength(stripCarName);
        }
    }

    static void checkNameExist(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다");
        }
        String[] splitCarNames = carNames.split(",");
        if (splitCarNames.length == 0) {
            throw new IllegalArgumentException("자동차 이름이 존재하지 않습니다");
        }
    }

    static void checkEmptyName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("쉼표 이후에 자동차 이름이 존재하지 않습니다");
        }
    }

    static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다");
        }
    }

    static void validateTryCount(String tryCount) {
        try {
            int tryCountNum = Integer.parseInt(tryCount);
            if (tryCountNum <= 0) {
                throw new IllegalArgumentException("시도할 횟수가 자연수가 아닙니다");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수가 자연수가 아닙니다");
        }
    }

    static String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    static String readTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
