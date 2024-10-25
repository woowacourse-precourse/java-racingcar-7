package racingcar.domain;

public class RacingCar {
    private final String name;
    private int raceScore;

    private RacingCar(String name){
        this.name = name;
        this.raceScore = 0;
    }

    public static RacingCar createRacingCar(String name){
        return new RacingCar(name);
    }
}
