package racingcar.controller;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarRacing;
import racingcar.view.UserInterface;

public class CarRacingController {

    private static final String WHITE_SPACE = " ";
    private static final String EMPTY_STRING = "";

    private final UserInterface userInterface;
    private CarRacing carRacing;
    private int totalRound;

    public CarRacingController() {
        this.userInterface = new UserInterface();
    }

    public void run() {
        setUpCarRacing();
        setUpTotalRound();
        startCarRacing();
        displayFinalWinner();
    }

    private void startCarRacing() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < totalRound; i++) {
            carRacing.moverCarsForwardRandomly();
            userInterface.showRoundResult(carRacing.getRacingCars());
        }
    }

    private void setUpCarRacing() {
        String carNameInput = userInterface.getRacingCarNameInput();
        List<String> carNames = validateCarNameInput(carNameInput);
        List<Car> racingCars = carNames.stream().map(Car::new).toList();
        this.carRacing = new CarRacing(racingCars);
    }

    private void setUpTotalRound() {
        totalRound = userInterface.getTotalRoundInput();
    }

    private void displayFinalWinner() {
        userInterface.showFinalWinner(carRacing.getWinners());
    }

    public List<String> validateCarNameInput(String carNameInput) {
        String trimmedCarNameInput = carNameInput.replaceAll(WHITE_SPACE, EMPTY_STRING);

        if (trimmedCarNameInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름으로 공백은 불가능합니다.");
        }
        if (!trimmedCarNameInput.contains(",")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표로 구분합니다. 쉼표를 입력해주세요.");
        }

        List<String> carNames = Arrays.stream(trimmedCarNameInput.split(",")).toList();
        if (carNames.size() == 1 || carNames.contains(EMPTY_STRING)) {
            throw new IllegalArgumentException("자동차 이름은 2개 이상 입력해야합니다.");
        }
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다: " + name);
            }
        }
        return carNames;
    }

}
