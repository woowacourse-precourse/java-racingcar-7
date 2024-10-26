package racingcar.view;

import static racingcar.constant.RacingCarInfoMsg.TYPE_CAR_NAMES;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    
    //TODO: 사용자로부터의 입력을 담당하는 클래스
    public String inputCarNames() {
        System.out.println(TYPE_CAR_NAMES.getMsg());
        return Console.readLine();
    }
}
