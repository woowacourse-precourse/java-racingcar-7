package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarFactory {
    public static List<RacingCar> createCars(String input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException();
        }

        String[] carNames = input.split(",");

        return Arrays.stream(carNames)
                .map(carName -> {
                    carName = carName.trim();

                    if(carName.length() > 5){
                        throw new IllegalArgumentException();
                    }

                    return new RacingCar(carName, "");
                })
                .toList();
    }
}
