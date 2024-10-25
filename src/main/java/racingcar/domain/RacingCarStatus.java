package racingcar.domain;

public class RacingCarStatus {
    private String name;
    private int position;

    public RacingCarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
