package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.IOMessage;

/**
 * 콘솔로 입력값을 다루는 클래스
 * 입력값을 받아서 CarController에게 전달한다.
 */
public class ConsoleInputView implements InputView {

    @Override
    public String getCarNames() {
        System.out.println(IOMessage.ENTER_CAR_NAMES);
        return Console.readLine();
    }

    @Override
    public String getChanceToMove() {
        System.out.println(IOMessage.ENTER_RACING_CHANCE);
        return Console.readLine();
    }

}
