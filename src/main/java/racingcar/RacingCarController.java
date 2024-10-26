package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class RacingCarController {

    private final RacingCarViewer racingCarViewer = new RacingCarViewer();
    private final RacingCarService racingCarService = new RacingCarService();

    public void startRacing() {

        racingCarViewer.promptCarNamesInput();
        String carNames = Console.readLine();
        racingCarViewer.promptTryNumber();
        int tryNumber = Integer.parseInt(Console.readLine());

        List<String> splitCarNames = racingCarService.splitCarNames(carNames);
        Map<String, String> racingResult = racingCarService.mapCarNames(splitCarNames);

        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            List<String> canMoveCarList = racingCarService.listMoveCarNames(splitCarNames);
            racingResult = racingCarService.moveCar(racingResult, canMoveCarList);
            racingCarViewer.showRacingResult(racingResult);
        }

        String maxMove = racingCarService.findMaxMove(racingResult);
        List<String> winners = racingCarService.listRacingWinners(racingResult, maxMove);

        racingCarViewer.showWinners(winners);
    }
}
