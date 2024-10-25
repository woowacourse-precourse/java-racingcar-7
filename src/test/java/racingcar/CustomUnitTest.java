package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.CarRepository;
import racingcar.model.raceGame.GameEngine;
import racingcar.util.StringProcessor;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialValidator;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomUnitTest {

    @Test
    void CHECK_RANDOM_GENERATOR(){
        int randomNumber = Randoms.pickNumberInRange(8,9);
        assertThat(randomNumber).isBetween(8,9);
    }


    @Test
    void CHECK_CAR_NAME_IS_EMPTY_EXCEPTION(){
        // arrange
        Validator<String[]> validator = new CarNameValidator();
        Car car = new Car(" ");

        // act

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(new String[]{car.getName()});
        });
    }

    @Test
    void CHECK_CAR_NAME_OVER_FIVE_LETTERS_EXCEPTION(){
        // arrange
        Validator<String[]> validator = new CarNameValidator();
        Car car = new Car("ABCDEF");

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(new String[]{car.getName()});
        });
    }

    @Test
    void CHECK_CAR_NAME_HAS_SPACE_IN_BETWEEN_EXCEPTION(){
        //arrange
        Validator<String[]> validator = new CarNameValidator();
        Car car = new Car("A B");

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(new String[]{car.getName()});
        });
    }

    @Test
    void TRIM_SPACES_AT_BOTH_ENDS(){

        String input = " pobi , woni ";
        String[] output = StringProcessor.process(input);

        assertThat(output).containsExactly("pobi","woni");
    }

    @Test
    void CHECK_TRIAL_NUMBER_IS_NUMBER_EXCEPTION(){
        //arrange
        String trial = "a";
        Validator<String> validator = new TrialValidator();

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(trial);
        });
    }

    @Test
    void CHECK_TRIAL_NUMBER_IS_NEGATIVE(){
        String trial = "-1";
        Validator<String> validator = new TrialValidator();

        assertThrows(IllegalArgumentException.class, () -> {
            validator.validate(trial);
        });
    }
}
