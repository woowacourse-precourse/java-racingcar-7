package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RaceRound;
import racingcar.model.RacingGame;
import racingcar.validator.CarValidator;
import racingcar.validator.RoundValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final Cars cars = new Cars();


    public void startGame(){
        try {
            String carNamesForString = InputView.getCarNames();
            CarValidator.isValid(carNamesForString);

            cars.addCarFromString(carNamesForString);

            String roundsForString = InputView.getNumberOfRounds();
            RoundValidator.isValid(roundsForString);

            RaceRound rounds = new RaceRound(Integer.parseInt(roundsForString), cars);

            roundStart(cars, rounds);
        } catch (IllegalArgumentException exception) {
            System.out.println("입력 오류: " + exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            System.out.println("문제가 발생하여 프로그램을 종료합니다.");
        }
    }

    private void roundStart(Cars cars, RaceRound rounds){
        RacingGame racingGame = new RacingGame(cars, rounds);
        OutputView.gameStart();

        racingGame.gameRoundStart();
        List<RaceRound> gameResult = racingGame.getEachRoundResult();

        gameResult.forEach(round -> OutputView.roundResult(round.toStringRoundResult()));

        Cars finalRoundCars = racingGame.getFinalRoundCarsStatus();
        endGame(finalRoundCars);
    }

    public void endGame(Cars finalRoundCars){
        Cars winnerCars = finalRoundCars.sortWinnerCars();
        OutputView.gameResult(winnerCars.toStringWinnerCars(winnerCars));
    }

}
