package racingcar.model;

public class MoveCommand {

    private final MoveStrategy moveStrategy;

    public MoveCommand(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void command(Cars cars) {
        for (String carName : cars.getCarPositions().keySet()) {
            checkedAndMoveCar(cars, carName);
        }
    }

    private void checkedAndMoveCar(Cars cars, String carName) {
        if (moveStrategy.canMove()) {
            cars.updateCarPosition(carName);
        }
    }

}
