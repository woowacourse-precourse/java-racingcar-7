package racingcar.domain.car;

public class Car {
    private final String name;
    private Integer position = 0;
    private final MovingStrategy movingStrategy;

    public Car(String carName, MovingStrategy movingStrategy) {
        validateCarName(carName);

        this.name = carName;
        this.movingStrategy = movingStrategy;
    }

    private void validateCarName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("자동차 이름은 null일 수 없습니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void move() {
        if (movingStrategy.canMove()) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }
}