package racingcar.domain;

public class Car { // 자동차를 관리하는 클래스
    private String car_name;
    private int position = 0;

    public Car(String car_name) {
        this.car_name = car_name;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
