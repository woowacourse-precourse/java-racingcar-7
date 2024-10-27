package racingcar.model;

public class RacingCarEmb implements RacingCar {
    private final String name;
    private int distance = 0;

    public RacingCarEmb(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public RacingCar increaseDistance(){
        this.distance++;
        return this;
    }
}
