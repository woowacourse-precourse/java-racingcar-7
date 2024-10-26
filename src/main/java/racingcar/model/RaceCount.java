package racingcar.model;

public record RaceCount(int raceCount) {
    public static RaceCount of(String raceCount) {
        return new RaceCount(Integer.getInteger(raceCount));
    }
}
