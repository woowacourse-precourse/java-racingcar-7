package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.GameService;
import racingcar.util.DataTransFormer;
import racingcar.validation.BlankNameValidator;
import racingcar.validation.NameLengthValidator;
import racingcar.validation.TrialTimesValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class GameController {

    public static void run() {
        ArrayList<String> carNames = InputView.getCarNames();
        String trialTimes = InputView.getTrialTimes();
        validateNameInput(carNames);
        validateTrialTimesInput(trialTimes);
        ArrayList<Car> carList = registerCars(carNames);
        startGame(carList, DataTransFormer.makeStringToInt(trialTimes));
        ArrayList<String> winners = chooseTheWinner(carList);
        anncounceTheWinner(winners);
    }

    private static void validateNameInput(ArrayList<String> carNames) {
        BlankNameValidator.validate(carNames);
        NameLengthValidator.validate(carNames);
    }

    private static void validateTrialTimesInput(String trialTimes) {
        TrialTimesValidator.validate(trialTimes);
    }

    private static ArrayList<Car> registerCars(ArrayList<String> carNames) {
        ArrayList<Car> carList = new ArrayList<>();
        fillCarList(carNames, carList);

        return carList;
    }

    private static void fillCarList(ArrayList<String> carNames, ArrayList<Car> carList) {
        for (String carName : carNames) {
            carList.add(Car.registerCarNameFrom(carName));
        }
    }

    private static void startGame(ArrayList<Car> carList, int trialTimes) {
        OutputView.printNoticeBeforeResult();
        while (trialTimes-- > 0) {
            proceedSingleRound(carList);
            showIntermediateResult(carList);
        }
    }

    private static void proceedSingleRound(ArrayList<Car> carList) {
        for (Car car : carList) {
            double randomNumber = GameService.makeRandNumberZeroToNine();
            boolean carMove = GameService.isAbleToMove(randomNumber);
            applyMoveResult(car, carMove);
        }
    }

    private static void applyMoveResult(Car car, boolean carMove) {
        if (carMove) {
            car.moveCar();
        }
    }

    private static void showIntermediateResult(ArrayList<Car> carList) {
        OutputView.printIntermediateResult(carList);
    }

    private static ArrayList<String> chooseTheWinner(ArrayList<Car> carList) {
        return GameService.makeWinnerList(carList);
    }

    private static void anncounceTheWinner(ArrayList<String> winners) {
        String winnerNames = DataTransFormer.makeJoinedString(winners);
        OutputView.printWinnerName(winnerNames);
    }
}
