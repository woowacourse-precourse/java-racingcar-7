package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final RacingCarService racingCarService = new RacingCarService();

    public void run() {
        try{
            Cars cars = new Cars(inputView.readCarsName());
            TryCount tryCount = new TryCount(inputView.readTryCount());
            startRace(cars, tryCount);
            printWinner(cars);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }catch(Exception e){
            System.out.println("[ERROR] 예상하지 못한 오류가 났습니다");
            e.getStackTrace();
            throw e;
        }
    }

    private void startRace(Cars cars, TryCount tryCount) {
        System.out.println("\n실행 결과");
        for(int i = 0 ; i < tryCount.getTryCount() ; i++){
            racingCarService.race(cars);
            outputView.printStatus(cars);
        }
    }

    private void printWinner(Cars cars) {
        List<String> winners = racingCarService.getWinners(cars);
        outputView.printResult(winners);
    }
}
