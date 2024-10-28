package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.constant.ErrorMessage;
import racingcar.constant.OutputMessage;
import racingcar.model.Racing;
import racingcar.service.InputService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    public void run() {
        InputView inputView = InputView.getInputViewInstance();
        inputView.printInputView();
        String carNames = inputView.getCarNames();

        InputService inputService = InputService.getInputServiceInstance();
        Map<String, Integer> racingCars = inputService.splitAndSaveCarName(carNames);
        Integer racingTotalRound = inputView.getTotalRacingRound();

        Racing racing = new Racing(racingCars, racingTotalRound);
        racing.race();
    }

    public void startRace() {
        // 예외 발생 시 에러 메시지 출력
        try{
            run();
        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.LOG_FOR_DEVELOPER.getMessage() + exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            System.out.println(ErrorMessage.EXCEPTION.getMessage());
            System.out.println(ErrorMessage.LOG_FOR_DEVELOPER.getMessage()+ exception.getMessage());
            throw exception;
        } finally {
            Console.close();
        }

    }

}
