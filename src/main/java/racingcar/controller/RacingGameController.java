package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.CarDto;
import racingcar.model.CarService;
import racingcar.model.InputService;
import racingcar.model.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {


    public void gamePlay() {
        try {
            //사용자 입력
            String carNames = InputView.carNames();
            String gameRounds = InputView.gameRounds();

            //사용자 입력 검증
            InputService inputService = new InputService();
            List<String> carNameList = inputService.carNamesValidation(carNames);
            int rounds = inputService.gameRoundsValidation(gameRounds);

            //자동차 생성
            CarService carService = new CarService(carNameList);
            List<CarDto> cars = carService.createCar();

            //게임시작
            RacingGameService racingGameService = new RacingGameService(cars);
            racingGameService.gameStart();

            //게임 진행 상황 출력
            OutputView outputView = new OutputView(carService.isSameName(), rounds);
            outputView.showResult(racingGameService.getCars());

            //우승자 출력
            List<CarDto> winners = racingGameService.whoIsWinners();
            outputView.showWinners(winners);

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;

        } finally {
            Console.close();
        }
    }
}
