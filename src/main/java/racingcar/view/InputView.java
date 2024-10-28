package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static void printCarNamesInputGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printMoveCountInputGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static String inputCarNames() {
        return Console.readLine();
    }

    public static String inputMoveCount() {
        try {
            return Console.readLine();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 자연수만 가능합니다.");
        }
    }
}
