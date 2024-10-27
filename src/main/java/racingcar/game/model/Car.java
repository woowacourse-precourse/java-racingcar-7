package racingcar.game.model;

public class Car {
    private Name name;
    private Position position;
    public Car(String carName) {
        this.name = new Name(carName);
        this.position = new Position();
    }

    public String getName() {
        return this.name.getName();
    }

    public void movePosition(Integer number) {
        position.move(number);
    }

    public Integer getPosition() {
        return position.getPosition();
    }
}
