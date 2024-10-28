package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class InputView {
    private static String getInput(String prompt) {
        System.out.println(prompt);
        try {
            return Console.readLine().trim();
        } catch (NoSuchElementException e) {
            System.out.println("입력 과정에서 오류가 발생했습니다. 빈 문자열을 처리합니다.");
            return "";
        }
    }
    public static String getCarNames() {
        return getInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static String getTotalRounds() {
        return getInput("시도할 횟수는 몇 회인가요?");
    }
}
