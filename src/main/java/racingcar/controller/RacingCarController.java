package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {
    private RacingCarService racingCarService;
    private  int tryCount;

        public void start(){
            List<String> nameList;
            nameList = InputView.getCarNames();
            tryCount = InputView.getTryCount();
            this.racingCarService = new RacingCarService(nameList);
        }

        public void run(){
            OutputView.printResultCommand();
            for (int i = 0; i < tryCount; i++) {
                racingCarService.playRound();
                OutputView.printRoundResult(racingCarService.getCarList());
                System.out.println();
            }
        }

        public void finish(){
            OutputView.printWinner(racingCarService.getWinningCarList());
        }
}
