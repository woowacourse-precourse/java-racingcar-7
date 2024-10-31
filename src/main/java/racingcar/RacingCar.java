package racingcar;

public class RacingCar {
    private long position;
    private String racingCarName;

    public RacingCar(String racingCarName) {
        this.racingCarName = racingCarName;
        this.position = INIT_POSITION;
    }

    public void forwardRacingCarPosition(int randomNumber) {
        if (randomNumber >= BOUNDARY_NUMBER) {
            position++;
        }
    }

    public long checkCurrentPosition() {
        return position;
    }

    public String readRacingCarName() {
        return racingCarName;
    }

    private final long INIT_POSITION = 0L;
    private final int BOUNDARY_NUMBER = 4;
}
