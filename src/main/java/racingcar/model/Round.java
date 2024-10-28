package racingcar.model;

import static racingcar.validation.ValidatorFactory.buildFactory;

import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

public class Round {
    private Integer round;

    private Round(String round) {
        validate(round);
        this.round = Integer.valueOf(round);
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = buildFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    public static Round of(String round) {
        return new Round(round);
    }

    public Boolean hasMoreRounds() {
        return round > 0;
    }

    public void keep() {
        round--;
    }

}
