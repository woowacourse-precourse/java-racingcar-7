package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static String getCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static String getRaceTurnMessage = "시도할 횟수는 몇 회인가요?";

    public static String inputCarName() {
        System.out.println(getCarNameMessage);
        return Console.readLine();
    }

    public static int inputRaceTurn() {
        System.out.println(getRaceTurnMessage);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
