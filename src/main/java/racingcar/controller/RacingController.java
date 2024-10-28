package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import racingcar.constant.ErrorMessage;
import racingcar.model.Racing;
import racingcar.service.CarNameService;
import racingcar.validator.Validator;
import racingcar.view.InputView;

public class RacingController {

    private void controlRaceGame() {
        InputView inputView = InputView.getInputViewInstance();
        inputView.printInputView();

        String carNames = inputView.getCarNames();
        CarNameService carNameService = CarNameService.getCarNameServiceInstance();
        Map<String, Integer> racingCars = carNameService.splitAndSaveCarName(carNames);

        String totalRacingRound = inputView.getTotalRacingRound();
        Validator validator = Validator.getValidator();
        Integer validTotalRacingRound =  validator.isValidRoundNumber(totalRacingRound); //유효성 검사

        Racing racing = new Racing(racingCars, validTotalRacingRound);
        racing.race();
    }

    // 예외 발생 시 에러 메시지 출력
    public void startRaceGame() {
        try {
            controlRaceGame();

        } catch (NumberFormatException exception) {
            System.out.println(ErrorMessage.NOT_VALID_TOTAL_ROUND_NUMBER);
            System.out.println(ErrorMessage.LOG_FOR_DEVELOPER + exception.getMessage());
            throw exception;

        } catch (IllegalArgumentException exception) {
            System.out.println(ErrorMessage.LOG_FOR_DEVELOPER + exception.getMessage());
            throw exception;

        } catch (Exception exception) {
            System.out.println(ErrorMessage.EXCEPTION);
            System.out.println(ErrorMessage.LOG_FOR_DEVELOPER + exception.getMessage());
            throw exception;

        } finally {
            Console.close();
        }
    }

}
