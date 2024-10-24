package racingcar.domain;

public class RaceReady {
    private final String nameInput;
    private final int numberOfTime;

    public RaceReady(String nameInput, String numberOfTime) {
        this.nameInput = nameInput;
        this.numberOfTime = parseInt(numberOfTime);
    }

    private int parseInt(String num) {
        try {
            int n = Integer.parseInt(num);
            isPositiveNum(n);
            return n;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도횟수는 양수만 입력 가능합니다.");
        }
    }

    public String getNameInput() {
        return nameInput;
    }

    public int getNumberOfTime() {
        return numberOfTime;
    }

    private void isPositiveNum(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("시도횟수는 0 또는 음수일 수 없습니다.");
        }
    }
}
