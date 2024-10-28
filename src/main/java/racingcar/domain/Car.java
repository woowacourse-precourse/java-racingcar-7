package racingcar.domain;

public class Car {
    private static final String FORWARD_MARK = "-";
    private final String name;
    private int position;
    private int forwardCount;
    private int consecutiveForwards;
    private int maxConsecutiveForwards;

    public Car(String name) {
        this.name = name;
        this.position = 0;
        this.forwardCount = 0;
        this.consecutiveForwards = 0;
        this.maxConsecutiveForwards = 0;
    }

    public void move(boolean shouldMove) {
        if (shouldMove) {
            moveForward();
            return;
        }
        resetConsecutiveForwards();
    }

    private void moveForward() {
        position++;
        forwardCount++;
        updateConsecutiveForwards();
    }

    private void updateConsecutiveForwards() {
        consecutiveForwards++;
        maxConsecutiveForwards = Math.max(maxConsecutiveForwards, consecutiveForwards);
    }

    private void resetConsecutiveForwards() {
        consecutiveForwards = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getPositionDisplay() {
        return FORWARD_MARK.repeat(position);
    }

    public double getForwardRate(int totalRounds) {
        if (totalRounds == 0) {
            return 0.0;
        }
        return (double) forwardCount / totalRounds * 100;
    }

    public int getMaxConsecutiveForwards() {
        return maxConsecutiveForwards;
    }
}