package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.util.CarInputConverter;
import racingcar.util.RaceInputConverter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public static void run() {
        //참가자 설정
        OutputView.requestCarName();
        String[] carNames = InputView.getCarNames();
        List<Car> raceParticipants = CarInputConverter.setCarList(carNames);

        //라운드 설정
        OutputView.requestRound();
        String inputRound = InputView.getRound();
        int round = RaceInputConverter.setIntRound(inputRound);


    }

}
