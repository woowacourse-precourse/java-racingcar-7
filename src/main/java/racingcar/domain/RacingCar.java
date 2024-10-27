package racingcar.domain;

public class RacingCar {
    private RacingCarName racingCarName;

    public RacingCar(final String racingCarName){
        this.racingCarName = new RacingCarName(racingCarName);
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }
}

