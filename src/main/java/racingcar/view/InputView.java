package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int inputTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return parseNumber(Console.readLine());
    }

    private static int parseNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            if(num <= 0) {
                throw new IllegalArgumentException("0 또는 음수는 입력할 수 없습니다: " + num);
            }
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자가 포함되어 있습니다: " + number);
        }
    }
}
