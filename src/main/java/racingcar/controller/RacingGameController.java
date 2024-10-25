package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.RaceRound;
import racingcar.model.RacingGame;
import racingcar.validator.CarValidator;
import racingcar.validator.RoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private Cars cars = new Cars();
    private RacingGame racingGame;


    public void startGame(){
        try {
            String carNamesForString = InputView.getCarNames();
            CarValidator.isValid(carNamesForString);

            cars.addCarFromString(carNamesForString);

            String roundsForString = InputView.getNumberOfRounds();
            RoundValidator.isValid(roundsForString);

            RaceRound rounds = new RaceRound(roundsForString);

            roundStart(cars, rounds);
        } catch (IllegalArgumentException exception) {
            System.out.println("입력 오류: " + exception.getMessage());
        } catch (Exception exception) {
            System.out.println("문제가 발생하여 프로그램을 종료합니다.");
        }
    }

    public void roundStart(Cars cars, RaceRound rounds){
        racingGame = new RacingGame(cars, rounds);
        OutputView.gameStart();
        racingGame.RoundsStart();
    }
}
