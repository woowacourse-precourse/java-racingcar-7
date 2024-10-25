package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DELIMITER = ",";

    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return input.split(DELIMITER);
    }

    public int getTryTime() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int result = Integer.parseInt(Console.readLine());

            if (result < 1) {
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");

            }

            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력해야 합니다.");
        }

    }

}
