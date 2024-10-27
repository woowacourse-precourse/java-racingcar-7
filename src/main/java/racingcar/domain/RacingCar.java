package racingcar.domain;

public class RacingCar {
    private RacingCarName racingCarName;
    private Location location;

    public RacingCar(final String racingCarName, final Location location){
        this.racingCarName = new RacingCarName(racingCarName);
        this.location = location;
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }
}

