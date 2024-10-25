package racingcar.domain;

public class Forward {

    private final int forwardCount;

    private Forward(String forwardCount) {
        this.forwardCount = parseToInt(forwardCount);
    }

    public static Forward from(String forwardCount) {
        return new Forward(forwardCount);
    }

    public int getForwardCount() {
        return forwardCount;
    }

    private int parseToInt(String forwardCount) {
        return Integer.parseInt(forwardCount);
    }

}