package racingcar.global.io;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String printCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return inputData();
    }

    public static String printTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return inputData();
    }

    private static String inputData() {
        String input;
        try {
            input = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return input;
    }


}
