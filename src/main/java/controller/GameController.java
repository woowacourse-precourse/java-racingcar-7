package controller;

import java.util.List;
import model.Car;
import service.RacingCarService;
import view.OutputView;

public class GameController {
    private final RacingCarService racingCarService;
    private final OutputView outputView;
    private boolean warningPrinted = false;

    public GameController(RacingCarService racingCarService, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.outputView = outputView;
    }

    public void startGame(List<Car> cars, int attempts) {
        showGameStartMessage();
        runGameRounds(cars, attempts);
    }

    private void runGameRounds(List<Car> cars, int attempts) {
        for (int i = 0; i < attempts; i++) {
            racingCarService.playSingleRound(cars);
            printRaceStatusIfAllowed(cars, attempts);
        }
    }

    public void announceWinners(List<Car> cars) {
        List<String> winners = racingCarService.findFinalWinners(cars);
        outputView.printFinalWinner(winners);
    }

    // 게임 시작 메시지 출력
    private void showGameStartMessage() {
        outputView.printEmptyLine();
        outputView.printExecutionResult();
    }

    private void printRaceStatusIfAllowed(List<Car> cars, int attempts) {
        if (!racingCarService.isPrintAllowed(attempts)) {
            printWarningMessageOnce();
            return;  // 조건에 맞지 않으면 즉시 종료
        }

        outputView.printRaceStatus(cars);  // 조건에 맞을 때만 실행
    }

    private void printWarningMessageOnce() {
        if (warningPrinted) {
            return;  // 이미 출력된 경우 아무것도 하지 않음
        }
        outputView.printWarningMessage();
        warningPrinted = true;  // 한 번 출력되면 다시 출력되지 않도록 설정
    }
}
