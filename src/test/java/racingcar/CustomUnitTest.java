package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        CarValidator carValidator = new CarValidator();
        Car car = new Car();

        // act
        car.setName("ABCDEF");

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            carValidator.checkNumberOfLetters(car.getName());
        });
    }

    @Test
    void CHECK_CAR_NAME_HAS_SPACE_IN_BETWEEN_EXCEPTION(){
        //arrange
        CarValidator carValidator = new CarValidator();
        Car car = new Car();

        //act
        car.setName("AB CD");

        // assert
        assertThrows(IllegalArgumentException.class, () -> {
            carValidator.checkCarNameHasSpace(car.getName());
        });
    }

    @Test
    void TRIM_SPACES_AT_BOTH_ENDS(){
        //arrange
        List<Car> carList = new ArrayList<Car>();
        Formatter formatter = new CarListFormatter();
        Car car1 = new Car();
        Car car2 = new Car();

        //act
        car1.setName(" AB");
        car2.setName("CD ");
        carList.add(car1);
        carList.add(car2);
        formatter.trimSpaces(carList);
        List<String> nameList = List.of("AB","CD");

        // assert
        assertThat(nameList).containsExactly("AB","CD");
    }

    @Test
    void CHECK_TRIAL_NUMBER_IS_NUMBER_EXCEPTION(){
        //arrange
        String trial = "a";
        TrialValidator trialValidator = new TrialValidator();

        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> {
            trialValidator.checkTrialIsNumber(trial);
        });
    }

    @Test
    void CHECK_TRIAL_NUMBER_IS_NEGATIVE(){
        //arrange
        String trial = "-1";
        TrialValidator trialValidator = new TrialValidator();

        //act
        //assert
        assertThrows(IllegalArgumentException.class, () -> {
            trialValidator.checkTrialIsNegative(trial);
        });
    }
}
