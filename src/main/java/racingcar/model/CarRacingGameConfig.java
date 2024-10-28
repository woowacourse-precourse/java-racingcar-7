package racingcar.model;

public class CarRacingGameConfig {

    public CarMovementPolicy carMovementPolicy() {
        return DefaultCarMovementPolicy.getInstance();
    }

    public CarCreator carCreator() {
        return CarCreator.getInstance();
    }
}