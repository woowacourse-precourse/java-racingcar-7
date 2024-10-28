package racingcar.car.model;

// 자동차 객체를 나타내는 클래스
public class Car {
    private final String name;
    private final int position; // 초기 위치는 0

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    private Car(String name, int position) {  // private 생성자
        this.name = name;
        this.position = position;
    }

    // 자동차를 전진시키는 메서드
    public Car move(int randomNumber) {
        if (randomNumber >= 4) {
            return new Car(this.name, this.position + 1);
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


