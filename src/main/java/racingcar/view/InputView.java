package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputCarName() {
        return Console.readLine();
    }

    public int inputRaceTryTimes() {
        try {
            int inputTryTimes = Integer.parseInt(Console.readLine());
            if (inputTryTimes < 0) {
                throw new IllegalArgumentException("횟수는 1 이상의 정수로 입력해 주세요.");
            }
            return inputTryTimes;
        } catch (Exception e) {
            throw new IllegalArgumentException("예상치못한 오류입니다.");
        }
    }
}
