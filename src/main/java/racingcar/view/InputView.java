package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.domain.dto.CarsSaveRequestDto;
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
    //----- 싱글톤 패턴 적용 -----//
    private static final InputView instance = new InputView();
    private InputView(){}
    public static InputView getInstance() {
        return instance;
    }
    //------------------------//

    public CarsSaveRequestDto getCarsName() {
        System.out.println(Message.INPUT_CARS_NAME);
        return new CarsSaveRequestDto(
                List.of(Console.readLine().split(","))
        );
    }

    public String getLapCount() {
        System.out.println(Message.INPUT_LAP_COUNT);
        return Console.readLine();
    }
}
