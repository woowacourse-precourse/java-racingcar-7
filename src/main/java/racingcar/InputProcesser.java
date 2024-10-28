package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputProcesser {
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine().replaceAll(" ", "");
        validateEmpty(carNames);

        return carNames;
    }

    public int getTryNums() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine().replaceAll(" ", "");
        validateEmpty(tryNumString);

        try {
            int tryNum = Integer.parseInt(tryNumString);
            return tryNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    private void validateEmpty(String inputString) {
        if (inputString.isEmpty() || inputString == null) {
            throw new IllegalArgumentException("아무런 내용이 입력되지 않았습니다.");
        }
    }
}
