package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingCarController {

    private final RacingCarViewer racingCarViewer = new RacingCarViewer();
    private final RacingCarService racingCarService = new RacingCarService();

    public void startRacing() {

        racingCarViewer.promptCarNamesInput();
        String carNames = Console.readLine();
        //여기도 입력 에러처리

        List<String> splitCarNames = racingCarService.splitCarNames(carNames);

        racingCarViewer.promptTryNumber();
        int tryNumber = Integer.parseInt(Console.readLine());
        //문자 입력시 오류처리
    }

}
