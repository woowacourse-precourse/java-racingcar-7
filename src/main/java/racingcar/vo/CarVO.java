package racingcar.vo;

/**
 * 자동차의 이름, 전진 횟수의 정보를 가지는 VO
 */
public class CarVO {
    private String carName;
    private int goCount = 0;


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getGoCount() {
        return goCount;
    }

    public void setGoCount(int goCount) {
        this.goCount = goCount;
    }

    public void goOneStep() {
        this.goCount += 1;
    }

    public CarVO(String carName) {
        this.carName = carName;
    }

    public CarVO(String carName, int goCount) {
        this.carName = carName;
        this.goCount = goCount;
    }

    @Override
    public String toString() {
        return String.format("carName : %s, goCount : %s", carName, goCount);
    }

}
