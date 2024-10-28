package controller;

import java.util.List;
import model.Car;
import service.RacingCarService;
import view.OutputView;

public class GameController {
    private final RacingCarService racingCarService;
    private final OutputView outputView;

    public GameController(RacingCarService racingCarService, OutputView outputView) {
        this.racingCarService = racingCarService;
        this.outputView = outputView;
    }

    public void startGame(List<Car> cars, int attempts) {
        outputView.showGameStartMessage();
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


    private void printRaceStatusIfAllowed(List<Car> cars, int attempts) {
        if (!racingCarService.isPrintAllowed(attempts)) { // 시도횟수가 1000보다 크면
            printWarningMessageOnce();                  // 경고 메세지를 한번만 출력
            return;
        }

        outputView.printRaceStatus(cars);  // 시도횟수가 1001보다 작은 일반적인 경우, 레이스 상황 출력
    }

    private void printWarningMessageOnce() {
        if (racingCarService.hasPrintedWarning()) { //경고가 이미 출력된 경우 아무것도 하지않음
            return;
        }
        outputView.printWarningMessage();
        racingCarService.setWarningFlag(); // 한 번 출력되면 다시 출력되지 않도록 설정
    }
}
