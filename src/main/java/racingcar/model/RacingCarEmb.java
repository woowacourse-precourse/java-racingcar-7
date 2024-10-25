package racingcar.model;

public class RacingCarEmb implements RacingCar {
    private final String name;
    private Long distance = 0L;

    public RacingCarEmb(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getDistance() {
        return distance;
    }

    @Override
    public void increaseDistance(){
        this.distance++;
    }
}
