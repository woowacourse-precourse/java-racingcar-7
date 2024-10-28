package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    // 사용자로 부터 자동차 이름들을 입력 받음
    public String inputCarName() {
        return Console.readLine();
    }

    // 사용자로 부터 자동차 이동 횟수를 입력 받음
    public String inputCarRoundCount() {
        return Console.readLine();
    }
}
