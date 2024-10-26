package racingcar.domain;

import racingcar.global.StepSymbol;

public class Car {

    private final String name;
    private Progress progress;
    private boolean isWinner = false;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 넘을 수 없습니다.");
        }
        this.name = name;
        this.progress = new Progress(StepSymbol.EMPTY_STRING.getValue());
    }

    public String getProgressResult() {
        return progress.getValue();
    }

    public void moveForward() {
        this.progress = progress.addStep(StepSymbol.STEP_STRING.getValue());
    }

    public void win() {
        this.isWinner = true;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner() {
        return isWinner;
    }
}
