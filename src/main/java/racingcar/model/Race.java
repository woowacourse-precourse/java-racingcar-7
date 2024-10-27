package racingcar.model;

public class Race {

    private final long raceNumber;
    private int count;

    private Race(long raceNumber) {
        this.raceNumber = raceNumber;
        this.count = 0;
    }

    public static Race of(long raceNumber) {
        return new Race(raceNumber);
    }

    public boolean hasNext() {
        if (count < raceNumber) {
            count++;
            return true;
        }
        return false;
    }
}
