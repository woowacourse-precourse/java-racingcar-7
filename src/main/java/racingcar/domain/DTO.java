package racingcar.domain;

public class DTO {
    private final String carName;
    private int forwardCount;

    public DTO(String carName, int forWardCount) {
        this.carName = carName;
        this.forwardCount = forWardCount;
    }

    public String getCarName() {
        return carName;
    }

    public int getForwardCount() {
        return forwardCount;
    }


    public void setForwardCount(int forwardCount) {
        this.forwardCount = forwardCount;
    }
}
