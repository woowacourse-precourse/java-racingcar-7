package racingcar.domain;

public class Car { // 자동차를 관리하는 클래스
    private String carName;
    private int position = 0;

    public Car(String carName) {
        this.carName = carName;
    }

    public String getCar_name() {
        return carName;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
