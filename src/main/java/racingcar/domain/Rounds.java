package racingcar.domain;

public class Rounds {

    private final int count;

    public Rounds(String rawCount) {
        this.count = toInt(rawCount);
    }

    private int toInt(String rawCount) {
        try {
            return Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수로 숫자를 입력해주세요.");
        }
    }

    public void repeat(Runnable moveAll) {
        for (int i = 0; i < count; i++) {
            moveAll.run();
        }
    }
}
