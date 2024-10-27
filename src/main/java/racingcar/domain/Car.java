package racingcar.domain;

public class Car implements Raceable {
    private final static int STEP_SIZE = 1;
    private final static char DISTANCE_SYMBOL = '-';
    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    @Override
    public void moveFoward() {
        this.moveCount += STEP_SIZE;
    }

    @Override
    public String getCurrentDistance() {
        StringBuilder progressBuilder = new StringBuilder();
        for (int i = 0; i < moveCount; i++) {
            progressBuilder.append(DISTANCE_SYMBOL);
        }
        return progressBuilder.toString();
    }
}
