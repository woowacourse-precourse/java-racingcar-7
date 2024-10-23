package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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
        Validator validator = new CarValidator();
        Car car = new Car();

        // act
        car.setName("");

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.checkEmptyOrNullCarName(car.getName());
        });
    }

    @Test
    void CHECK_CAR_NAME_OVER_FIVE_LETTERS_EXCEPTION(){
        // arrange
        Validator validator = new CarValidator();
        Car car = new Car();

        // act
        car.setName("ABCDEF");

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.checkNumberOfLetters(car.getName());
        });
    }

    @Test
    void CHECK_CAR_NAME_HAS_SPACE_INBETWEEN_EXCEPTION(){
        //arrange
        Validator validator = new CarValidator();
        Car car = new Car();

        //act
        car.setName("AB CD");

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            validator.checkCarNameHasSpace(car.getName());
        });
    }
}
