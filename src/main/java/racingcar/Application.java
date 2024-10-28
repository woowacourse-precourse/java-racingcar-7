package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String racingCarsNames = Console.readLine();
        List<Car> carArray = createCar(racingCarsNames);

    }

    public static List<Car> createCar(String racingCarsNames) {
        if(racingCarsNames == null || racingCarsNames.isBlank()) {
            throw new IllegalArgumentException();
        }

        List<Car> carArray =  new ArrayList<>();
        String[] carsNames = racingCarsNames.split(",");

        for (String carName : carsNames) {
            if(carName.isBlank()) {
                continue;
            }

            carName = carName.trim();

            if(carName.length() > 5) {
                throw new IllegalArgumentException();
            }

            carArray.add(new Car(carName));
        }

        return carArray;
    }
}
