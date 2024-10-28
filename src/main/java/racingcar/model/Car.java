package racingcar.model;

public class Car {
    private String name;
    private int position;

    public Car(String nameInput) {
        this.name = nameInput;
        this.position = 0;
    }
    public Car(String nameInput , int position) {// 테스트 코드를 위한 포지션 주입이 가능한 생성자
        this.name = nameInput;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void moveForward() {
        position++;
    }

    public int getPosition() {
        return position;
    }
}
