package racingcar;

public class Car {

    private final String name;
    private final RaceRecords raceRecords;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.raceRecords = new RaceRecords();
    }

    public void initializeRecords(int raceCount) {
        raceRecords.initializeRecords(raceCount);
    }

    public void recordPrevRaceByRound(int round) {
        raceRecords.recordPrevRaceByRound(round);
    }

    public void moveForward(int round) {
        raceRecords.recordRaceByRound(round);
    }

    private void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
