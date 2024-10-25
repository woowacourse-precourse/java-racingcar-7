package racingcar.model;

public class MoveCommand {

    private final MoveStrategy moveStrategy;

    public MoveCommand(final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void command(final Cars cars) {
        for (String carName : cars.getCarPositions().keySet()) {
            checkedAndMoveCar(cars, carName);
        }
    }

    private void checkedAndMoveCar(final Cars cars, final String carName) {
        if (moveStrategy.canMove()) {
            cars.updateCarPosition(carName);
        }
    }

}
