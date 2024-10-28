package racingcar;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private final String name;
    private final Condition condition;
    private int position;

    public Car(String CarName) {
        this.name = CarName;
        this.condition = new MoveCondition();
    }

    public String getName() {
        return name;
    }

    public void move(){
        if (condition.getCondition()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
