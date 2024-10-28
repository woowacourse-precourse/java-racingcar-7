package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.model.Racing;
import racingcar.service.InputService;
import racingcar.view.InputView;

public class RacingController {

    public void run() {
        InputView inputView = new InputView();
        inputView.printInputView();
        String carNames = inputView.getCarNames();

        InputService inputService = new InputService();
        Map<String, Integer> racingCars = inputService.splitAndSaveCarName(carNames);
        Integer racingTotalRound = inputView.getTotalRacingRound();

        Racing racing = new Racing(racingCars, racingTotalRound);
        racing.race();
    }

    public void startRace() {
        try{
            run();
        } catch (IllegalArgumentException exception) {
            System.out.println("[예외 로그] : " + exception.getMessage());
            throw new IllegalArgumentException();
        } catch (Exception exception) {
            System.out.println("예기치 못한 문제가 발생했습니다.");
            System.out.println("[개발자용 로그]: " + exception.getMessage());
        } finally {
            Console.close();
        }

    }

}
