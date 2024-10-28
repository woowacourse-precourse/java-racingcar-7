package racingcar.domain;

public class Rounds {

    private final int count;

    public Rounds(String rawCount) {
        int count = toInt(rawCount);
        validatePositive(count);
        this.count = count;
    }

    public void repeat(Runnable moveAll) {
        for (int i = 0; i < count; i++) {
            moveAll.run();
        }
    }

    private int toInt(String rawCount) {
        try {
            return Integer.parseInt(rawCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수로 숫자를 입력해주세요.");
        }
    }

    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("시도할 횟수로 양수를 입력해주세요.");
        }
    }
}
