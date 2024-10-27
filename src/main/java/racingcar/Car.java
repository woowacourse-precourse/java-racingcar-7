package racingcar;

public class Car {
    private final int nameMaxLength = 5;
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > nameMaxLength) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public void move(Movement movement) {
        if(movement.canMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
