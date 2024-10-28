package racingcar;

import static racingcar.RacingConstants.MAX_NUMBER_IN_RANGE;
import static racingcar.RacingConstants.MIN_NUMBER_IN_RANGE;
import static racingcar.RacingConstants.MIN_NUMBER_TO_MOVE;

public class AppConfig {
    public RacingInitializer racingInitializer() {
        return new RacingInitializer(inputView(), inputController());
    }

    public InputView inputView() {
        return new InputView();
    }

    public InputController inputController() {
        return new InputController(inputValidator());
    }

    public InputValidator inputValidator() {
        return new InputValidator();
    }

    public CarRacing carRacing() {
        return new CarRacing(racingRule(), totalRounds(), racers(), outputView());
    }

    public RacingRule racingRule() {
        return new RacingRule(MIN_NUMBER_IN_RANGE, MAX_NUMBER_IN_RANGE, MIN_NUMBER_TO_MOVE);
    }

    public int totalRounds() {
        return racingInitializer().registerTotalRounds();
    }

    public Racers racers() {
        return racingInitializer().registerRacers();
    }

    public OutputView outputView() {
        return new OutputView();
    }
}