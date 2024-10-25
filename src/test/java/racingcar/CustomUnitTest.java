package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.validator.CarNameValidator;
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
//
//    @Test
//    void CHECK_CAR_NAME_OVER_FIVE_LETTERS_EXCEPTION(){
//        // arrange
//        CarValidator carValidator = new CarValidator();
//        Car car = new Car();
//
//        // act
//        car.setName("ABCDEF");
//
//        // assert
//        assertThrows(IllegalArgumentException.class, () -> {
//            carValidator.checkNumberOfLetters(car.getName());
//        });
//    }
//
//    @Test
//    void CHECK_CAR_NAME_HAS_SPACE_IN_BETWEEN_EXCEPTION(){
//        //arrange
//        CarValidator carValidator = new CarValidator();
//        Car car = new Car();
//
//        //act
//        car.setName("AB CD");
//
//        // assert
//        assertThrows(IllegalArgumentException.class, () -> {
//            carValidator.checkCarNameHasSpace(car.getName());
//        });
//    }
//
//    @Test
//    void TRIM_SPACES_AT_BOTH_ENDS(){
//        //arrange
//        List<Car> carList = new ArrayList<Car>();
//        Formatter formatter = new CarListFormatter();
//        Car car1 = new Car();
//        Car car2 = new Car();
//
//        //act
//        car1.setName(" AB");
//        car2.setName("CD ");
//        carList.add(car1);
//        carList.add(car2);
//        formatter.trimSpaces(carList);
//        List<String> nameList = List.of("AB","CD");
//
//        // assert
//        assertThat(nameList).containsExactly("AB","CD");
//    }
//
//    @Test
//    void CHECK_TRIAL_NUMBER_IS_NUMBER_EXCEPTION(){
//        //arrange
//        String trial = "a";
//        TrialValidator trialValidator = new TrialValidator();
//
//        //act
//        //assert
//        assertThrows(IllegalArgumentException.class, () -> {
//            trialValidator.checkTrialIsNumber(trial);
//        });
//    }
//
//    @Test
//    void CHECK_TRIAL_NUMBER_IS_NEGATIVE(){
//        //arrange
//        String trial = "-1";
//        TrialValidator trialValidator = new TrialValidator();
//
//        //act
//        //assert
//        assertThrows(IllegalArgumentException.class, () -> {
//            trialValidator.checkTrialIsNegative(trial);
//        });
//    }
//
//    @Test
//    void CHECK_RANDOM_NUMBER_OVER_FOUR_PROGRESS_AND_UNDER_FOUR_NOT(){
//        // arrange
//        RaceGame raceGame = new RaceGame();
//        List<Car> carList = new ArrayList<Car>();
//        Car car1 = new Car();
//        Car car2 = new Car();
//        int car1Number = 3;
//        int car2Number = 5;
//
//        // act
//        carList.add(car1);
//        carList.add(car2);
//        raceGame.setCars(carList);
//        raceGame.progress(car1, car1Number);
//        raceGame.progress(car2, car2Number);
//
//        assertThat(car1.getProgress()).isEqualTo(0);
//        assertThat(car2.getProgress()).isEqualTo(1);
//    }
}
