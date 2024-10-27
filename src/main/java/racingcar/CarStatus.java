package racingcar;

public class CarStatus {
    private final String name;
    private final int position;
    private final int round;


    public CarStatus(
            String name,
            int position,
            int round
    ) {
        this.name = name;
        this.position = position;
        this.round = round;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
