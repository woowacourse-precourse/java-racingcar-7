package racingcar.model;

public class RacingCar {
    private final String name;
    private final StringBuilder raceResult;

    public RacingCar(String name) {
        this.name = name;
        this.raceResult = new StringBuilder();
    }

    public void move() {
        raceResult.append("-");
    }

    public String result() {
        return name + " : " + raceResult.toString();
    }

    public int getRaceResultLength() {
        return raceResult.length();
    }

    public String getName() {
        return name;
    }

    public RacingCar copy() {
        RacingCar copiedCar = new RacingCar(name);
        copiedCar.raceResult.append(raceResult);
        return copiedCar;
    }
}
