package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        // 이름 입력 받기
        String rawInputCarNames = inputView.inputCarNames();

        List<String> carNames = Arrays.asList(rawInputCarNames.split(","));
        if (!isValidName(carNames)) {
            throw new IllegalArgumentException("이름이 5글자가 넘습니다");
        }
        if (isNameOverlap(carNames)) {
            throw new IllegalArgumentException("중복된 이름을 입력할 수 없습니다.");
        }

        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }

        // 횟수 입력받기
        int repeatNumber = stringToInt();

        // 랜덤
        int randomValue;

        outputView.printExecutionResult();
        for (int i = 0; i < repeatNumber; i++) {
            for (Car car : carList) {
                randomValue = createRandomValue();
                if (randomValue >= 4) {
                    int currentForwardCount = car.getForwardCount();
                    car.setForwardCount(currentForwardCount + 1);
                }
            }
            outputView.printCurrentRoundRacingResult(carList);
        }

        List<String> finalWinner = findFinalWinner(carList);
        outputView.printFinalRacingResult(finalWinner);

    }

    private int stringToInt() {
        int gameCountInt = -1;
        String gameCountString = inputView.inputRoundNumber();
        if (isPositiveOrZeroInteger(gameCountString)) {
            gameCountInt = Integer.parseInt(gameCountString);
        }

        return gameCountInt;
    }

    private boolean isPositiveOrZeroInteger(String gameCountString) {
        if (!gameCountString.matches("\\d+")) {
            throw new IllegalArgumentException("0 이상의 정수를 입력해주세요.");
        }

        return true;
    }

    private int createRandomValue() {
        return Randoms.pickNumberInRange(0, 9);
    }

    private boolean isValidName(List<String> carNames) {
        for (String car : carNames) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;
    }

    private boolean isNameOverlap(List<String> carNames) {
        int carCount = carNames.size();
        for (int i = 0; i < carCount - 1; i++) {
            for (int j = i + 1; j < carCount; j++) {
                if (carNames.get(i).equals(carNames.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<String> findFinalWinner(List<Car> cars) {
        List<String> finalWinner = new ArrayList<>();
        int winnerFowardCount = findWinnerForward(cars);

        for (Car car : cars) {
            if (car.getForwardCount() == winnerFowardCount) {
                finalWinner.add(car.getName());
            }
        }

        return finalWinner;
    }

    private int findWinnerForward(List<Car> cars) {
        int winnerForwardCount = 0;

        for (Car car : cars) {
            if (car.getForwardCount() > winnerForwardCount) {
                winnerForwardCount = car.getForwardCount();
            }
        }

        return winnerForwardCount;
    }

}
