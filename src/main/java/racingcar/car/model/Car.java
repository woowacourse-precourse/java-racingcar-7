package racingcar.car.model;

// 자동차 객체를 나타내는 클래스
public class Car {
    private final String name;
    private int position = 0;  // 초기 위치는 0

    public Car(String name) {
        this.name = name;
    }

    // 자동차를 전진시키는 메서드
    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            position++;  // 랜덤 숫자가 4 이상일 때 전진
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
