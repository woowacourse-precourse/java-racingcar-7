package racingcar.domain;

import racingcar.validation.Validation;

public class Racingcar {
    private String name;

    public Racingcar(String name) {
        Validation.validateRacingcarName(name);
        this.name = name;
    }

}

