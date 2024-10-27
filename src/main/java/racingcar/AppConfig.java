package racingcar;

import racingcar.io.Input;
import racingcar.io.Output;
import racingcar.racing.CarFactory;
import racingcar.racing.RacingManager;
import racingcar.racing.RoundRace;
import racingcar.racing.Winner;
import racingcar.validation.ValidateInput;

public class AppConfig {
    public CarFactory carFactory() {
        return new CarFactory();
    }

    public RoundRace roundRace() {
        return new RoundRace();
    }

    public Winner winner(){
        return new Winner();
    }

    public Output output() {
        return new Output();
    }

    public RacingManager RacingManager() {
        return new RacingManager(carFactory(), roundRace(), winner(), output());
    }
}
