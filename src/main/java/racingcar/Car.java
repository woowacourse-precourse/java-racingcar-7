package racingcar;

public class Car {
    private String name;
    private int position;
    private MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
    	if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (moveStrategy.canMove()) {
            position++;
        }
    }
}