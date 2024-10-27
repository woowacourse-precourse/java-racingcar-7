package racingcar;

public class Record {
    private final String name;
    private final long moveCount;

    public Record(Car car) {
        this.name = car.getName();
        this.moveCount = car.getMoveCount();
    }

    public long getMoveCount() {
        return moveCount;
    }
}
