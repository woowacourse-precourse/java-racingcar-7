package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import java.util.Arrays;
import java.util.List;

public class GameFlow {
    private Cars cars;
    private int numberOfMoves;

    public GameFlow() {}

    public void start() {
        List<String> carNames = parseCarNames();
        cars = new Cars(carNames);
        setNumberOfMoves();
        // runRace();
        // displayWinners();
    }

    private List<String> parseCarNames() {
        String carNameInput = InputView.inputCarNames();
        List<String> carNames = Arrays.asList(carNameInput.split(","));
        return carNames;
    }
    
    private void setNumberOfMoves() {
        String NumberInput = InputView.inputNumberOfMoves();
        validateNumberOfMoves(NumberInput);
        numberOfMoves = Integer.parseInt(NumberInput);
    }
    
    private void validateNumberOfMoves(String NumberInput) {
        try {
            int NumberOfMoves = Integer.parseInt(NumberInput);
            if (NumberOfMoves <= 0) {
                throw new IllegalArgumentException("이동 횟수는 1 이상의 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동 횟수는 아라비아 숫자여야 합니다.");
        }
    }
    


}
