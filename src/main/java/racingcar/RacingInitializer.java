package racingcar;

import static racingcar.RacingConstants.INITIAL_MOVE_COUNT;

import java.util.List;

public class RacingInitializer {
    private final InputView inputView;
    private final InputController inputController;

    public RacingInitializer(InputView inputView, InputController inputController) {
        this.inputView = inputView;
        this.inputController = inputController;
    }

    public Racers registerRacers() {
        String inputNames = inputView.requestCarNames();
        List<String> carNames = inputController.extractCarNames(inputNames);
        return new Racers(carNames.stream().map(name -> new Car(name, INITIAL_MOVE_COUNT)).toList());
    }

    public int registerTotalRounds() {
        String inputAttempts = inputView.requestTotalAttempts();
        return inputController.convertToNumber(inputAttempts);
    }
}