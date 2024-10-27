package racingcar.utils;

import racingcar.model.Car;

import java.util.Arrays;
import java.util.List;

public class StringConvertor {
    private StringConvertor(){
    }

    public static int toInt(String input){
        return Integer.parseInt(input);
    }

    public static List<Car> toCarList(String input) {
        String[] split = input.split(",");
        return Arrays.stream(split).map(Car::new).toList();
    }
}

