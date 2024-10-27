package racingcar.vehicle;

import racingcar.io.OutputManager;

public class Car {
    private String name;
    private int cnt;

    public Car(String name) {
        imPossibleName(name);

        this.name = name;
        cnt = 0;
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }

    public void run(int randomNum) {
        if (randomNum < 0) {
            throw new IllegalArgumentException("랜덤값은 음수가 들어올 수 없습니다.");
        }
        if (randomNum < 4) {
            OutputManager.getInstance().print(toString());
            return;
        }
        cnt++;
        OutputManager.getInstance().print(toString());
    }

    @Override
    public String toString() {
        return name + " : " + printCnt();
    }

    private String printCnt() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            builder.append("-");
        }
        return builder.toString();
    }

    private void imPossibleName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
