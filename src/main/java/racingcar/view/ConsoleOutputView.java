package racingcar.view;

import racingcar.model.dto.RacingResult;

/**
 * 콘솔을 통해 출력을 담당하는 클래스
 */
public class ConsoleOutputView implements OutputView {

    @Override
    public void printResult(RacingResult result) {
        System.out.println(result);
    }

}
