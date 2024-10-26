package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine().split(",");
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            name = name.trim(); // 이름 양쪽의 공백 제거
            if (name.length() > 5 || name.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
            }
        }
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int tryCount = Integer.parseInt(Console.readLine());
            if (tryCount <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

}
