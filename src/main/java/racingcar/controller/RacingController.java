package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final RacingGameService racingGameService;

    public RacingController(RacingGameService racingGameService){
        this.racingGameService = racingGameService;
    }

    public void startRacingGame(){
        try {
            String carNames = getCarNames();
            String tryCountInString = getTryCount();
            Integer tryCount = racingGameService.convertTryCountToInt(tryCountInString);

            List<RacingCar> racingCars = racingGameService.initializeRacingGame(carNames, tryCount);

            OutputView.printResultMessage();

            for (int i = 0; i < tryCount; i++){
                moveRacingCars(racingCars);
                OutputView.printGame(racingCars);
            }

            List<RacingCar> winners = racingGameService.getWinners(racingCars);

            OutputView.printWinners(winners);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private void moveRacingCars(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars){
            racingCar.move(Randoms.pickNumberInRange(0, 9));
        }
    }
    public String getCarNames(){
        InputView.printNameInputMessage();
        return InputView.getInput();
    }

    public String getTryCount(){
        InputView.printTimeInputMessage();;
        return InputView.getInput();
    }
}
