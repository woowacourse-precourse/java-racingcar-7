package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.Message;

/**
 * packageName    : racingcar.view
 * fileName       : inputView
 * author         : ehgur
 * date           : 2024-10-24
 * description    : 입력 처리를 담당하는 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-10-24         ehgur            최초 생성
 */

public class InputView {

    public String[] getCarsName() {
        System.out.println(Message.INPUT_CARS_NAME);
        return Console.readLine().split(",");
    }

    public int getLapCount() {
        System.out.println(Message.INPUT_LAP_COUNT);
        return Integer.parseInt(Console.readLine());
    }
}
