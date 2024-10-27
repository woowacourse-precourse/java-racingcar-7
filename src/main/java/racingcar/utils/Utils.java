package racingcar.utils;

import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static List<String> splitInputCar(String inputCarName){

        return Arrays.stream(inputCarName.split(","))
                .map(Validator::validateCarNameUnderFive)
                .collect(Collectors.toList());
    }

    public static List<Car> inputCarNameToList(){

        return InputView.inputCarName()
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
