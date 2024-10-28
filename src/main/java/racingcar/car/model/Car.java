package racingcar.car.model;

public class Car {
    private final String name;
    private final int position;

    public Car(String name) {
        this.name = name;
        this.position = 0; //초기 위치 0
    }

    // 이동 후 새로운 위치로 자동차 객체 생성 (불변 객체 패턴)
    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(int randomNumber) {
        if (randomNumber >= 4) {
            return new Car(this.name, this.position + 1); // 새로운 위치로 객체 생성
        }
        return this;  // 이동이 없을 경우 현재 객체 반환
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}


