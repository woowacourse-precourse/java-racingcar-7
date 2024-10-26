package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        isCorrectSeparator(carNames);
        isLastStringComma(carNames);
        return carNames;
    }

    public static int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return isTryNumberDigit();
    }

    public static String[] getCars() {
        String carNames = getCarNames();
        isEmpty(carNames.split(","));
        return carNames.split(",");
    }

    public static void isCorrectSeparator(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }

    public static void isLastStringComma(String carNames) {
        if (carNames.endsWith(",")) {
            throw new IllegalArgumentException("참여할 자동차를 끝까지 입력해주세요.");
        }
    }

    private static int isTryNumberDigit() {
        int tryNumber;
        try {
            tryNumber = isDigit(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 이외의 값은 입력할 수 없습니다.");
        }
        return tryNumber;
    }

    public static int isDigit(String inputNumber) {
        return Integer.parseInt(inputNumber);
    }

    public static void isEmpty(String[] cars) {
        for (String car : cars) {
            if (car.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함되어 있습니다.");
            }
        }
    }
}

