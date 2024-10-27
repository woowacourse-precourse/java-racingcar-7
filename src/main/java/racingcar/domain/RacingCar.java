package racingcar.domain;

public class RacingCar {
    private static final int MOVING_CONDITION = 4;

    private RacingCarName racingCarName;
    private Location location;

    public RacingCar(final String racingCarName, final Location location){
        this.racingCarName = new RacingCarName(racingCarName);
        this.location = location;
    }

    public void move(final int randomNumber){
        if(randomNumber >= MOVING_CONDITION){
            this.location = location.increase();
        }
    }

    public RacingCarName getRacingCarName() {
        return racingCarName;
    }

    public Location getLocation() {
        return location;
    }
}

