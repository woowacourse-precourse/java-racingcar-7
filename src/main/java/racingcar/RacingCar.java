package racingcar;

public record RacingCar(
        String name
) {

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static RacingCar from(String name) {
        return new RacingCar(name);
    }
}
