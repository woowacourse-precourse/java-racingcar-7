package racingcar.domain;

public class RacingCar {
    private static final int MOVING_CONDITION = 4;

    private RacingCarName racingCarName;
    private Location location;

    public RacingCar(final String racingCarName, final int location){
        this.racingCarName = new RacingCarName(racingCarName);
        this.location = new Location(location);
    }

    public void move(final int randomNumber){
        if(randomNumber >= MOVING_CONDITION){
            this.location = location.increase();
        }
    }

    public String getRacingCarName() {
        return racingCarName.racingCarName();
    }

    public int getLocation() {
        return location.location();
    }
}

