package racingcar.domain;

public record Location(int location) {
    private static final int MOVE_VALUE = 1;

    public Location increase(){
        return new Location(location + MOVE_VALUE);
    }
}
