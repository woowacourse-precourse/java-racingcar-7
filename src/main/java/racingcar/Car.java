package racingcar;

public class Car {

    private final String name;
    private int position;


    public Car(String name) {
        if (name.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        this.name = name;
    }

    public void move(boolean canMove) {
        if(canMove){
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
