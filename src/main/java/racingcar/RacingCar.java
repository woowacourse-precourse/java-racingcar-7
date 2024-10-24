package racingcar;

public class RacingCar {
    private long position;
    private String racingCarName;

    public RacingCar(String racingCarName) {
        this.racingCarName = racingCarName;
        this.position = 0L;
    }

    public void forwardRacingCarPosition() {
        position++;
    }

    public long checkCurrentPosition() {
        return position;
    }

    public String readRacingCarName() {
        return racingCarName;
    }
}
