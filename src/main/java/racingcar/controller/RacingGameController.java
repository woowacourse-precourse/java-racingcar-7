package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    public static void game() {
        List<String> carNames = InputView.getCars();
        validateName(carNames);

        int round = validateRound(InputView.getRounds());
        Cars cars = createCars(carNames);

        OutputView.printResultText();
        for (int i = 0; i < round; i++) {
            moveCars(cars);
            OutputView.printResult(cars);
        }

        OutputView.printWinner(getWinner(cars));
    }

    private static List<Car> getWinner(Cars cars) {
        List<Car> carList = cars.getCarList();
        List<Car> winner = new ArrayList<>();

        int max = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }
    private static Cars createCars(List<String> carNames) {
        return new Cars(carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()));
    }
    private static void moveCars(Cars cars) {
        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            car.move();
        }
    }

    private static void validateName(List<String> carNames) {
        checkDuplicateNames(carNames);
        carNames.forEach(RacingGameController::checkNameFormat);
        carNames.forEach(RacingGameController::checkNameLength);
    }

    private static void checkDuplicateNames(List<String> carNames) {
        List<String> distinctValidateCarName = carNames
                .stream()
                .distinct()
                .toList();

        if (distinctValidateCarName.size() != carNames.size()) {
            throw new IllegalArgumentException("자동차의 이름은 중복될 수 없습니다.");
        }
    }

    private static void checkNameFormat(String carName) {
        if(!carName.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("자동차의 이름은 알파벳이어야 합니다.");
        }
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > 5){
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하여야 합니다.");
        }
    }

    private static int validateRound(String round) {
        checkIsNumeric(round);
        int roundNum = parseRound(round);
        checkRoundPositive(roundNum);
        return roundNum;
    }
    private static void checkIsNumeric(String round) {
        if (!round.matches("[0-9]+")) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }
    private static void checkRoundPositive(int roundNum) {
        if (roundNum < 1) {
            throw new IllegalArgumentException("0보다 큰 수를 입력해주세요");
        }
    }

    private static int parseRound(String round) {
        return Integer.parseInt(round);
    }
}
