package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.util.Constants.MAX_NAME_LENGTH;

public class CarService {

    public List<Car> playRounds(String playersName, int moveCount) {
        List<String> names = splitByComma(playersName);
        validateName(names);
    }

    public List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private void validateName(List<String> names){
        validateBlank(names);
        validateLength(names);
    }

    private void validateBlank(List<String> names){
        for(String name : names){
            if(name.isEmpty() || name.isBlank())
                throw new IllegalArgumentException();
        }
    }
    private void validateLength(List<String> names){
        for(String name : names){
            if(name.length() > MAX_NAME_LENGTH)
                throw new IllegalArgumentException();
        }
    }
}
