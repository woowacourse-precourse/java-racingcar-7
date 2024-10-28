package racingcar.model;

import racingcar.dto.Result;

public class Car {
    private String name;
    private int step;

    public Car(String name) {
        validateName(name);

        this.name = name;
        this.step = 0;
    }

    public Result.Round go(int num) {
        if (num >= 4)
            this.step++;
        return result();
    }

    private Result.Round result() {
        return new Result.Round(this.name, this.step);
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
