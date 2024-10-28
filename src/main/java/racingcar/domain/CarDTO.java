package racingcar.domain;

public class CarDTO {
    private String carName;
    private int goStraight;

    public CarDTO(String carName) {
        this.carName = carName;

        this.goStraight = 0;//초기값은 0으로 설정
    }

    public String getCarName() {
        return carName;
    }

    public int getGoStraight() {
        return goStraight;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setGoStraight(int goStraight) {
        this.goStraight = goStraight;
    }

    // 한 칸씩 이동될 때마다 증가
    public void moveForward() {
        goStraight++;
    }


}
