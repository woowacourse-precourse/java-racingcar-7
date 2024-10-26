package racingcar.model;
public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        //TODO: 이름 예외처리
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4)
            position++;
    }

}
