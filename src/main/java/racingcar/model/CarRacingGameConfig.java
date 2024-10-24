package racingcar.model;

public class CarRacingGameConfig {

    public CarMovementPolicy carMovementPolicy() {
        return DefaultCarMovementPolicy.getInstance();
    }

    public CarCreator carFactory() {
        return CarCreator.getInstance();
    }
}