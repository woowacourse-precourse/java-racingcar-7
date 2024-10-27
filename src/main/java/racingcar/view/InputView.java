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
                throw new Exception();
            }
            return inputTryTimes;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
