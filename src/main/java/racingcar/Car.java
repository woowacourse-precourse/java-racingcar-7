package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position;
    private final StringBuilder executionResult;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
        this.executionResult = new StringBuilder(name + " : ");
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public StringBuilder getExecutionResult() {
        return executionResult;
    }

    public void move() {

        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
            executionResult.append("-");
        }
    }
}
