package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputProcesser {
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine().replaceAll(" ", "");
        validateBlank(carNames);

        return carNames;
    }

    public int getTryNums() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine().replaceAll(" ", "");

        validateBlank(tryNumString);
        validateInteger(tryNumString);

        int tryNum = Integer.parseInt(tryNumString);
        validatePositive(tryNum);

        return tryNum;
    }

    private void validateBlank(String inputString) {
        if (inputString.isEmpty() || inputString == null) {
            throw new IllegalArgumentException("아무런 내용이 입력되지 않았습니다.");
        }
    }

    private void validateInteger(String tryNumString) {
        try {
            Integer.parseInt(tryNumString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자를 입력해 주세요.");
        }
    }

    private void validatePositive(int inputNum) {
        if (inputNum <= 0) {
            throw new IllegalArgumentException("실행횟수는 양수만 입력 가능합니다.");
        }
    }
}
