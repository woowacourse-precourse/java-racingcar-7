package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String racingCarsNames = Console.readLine();
        List<Car> carArray = createCar(racingCarsNames);

    }

    private static List<Car> createCar(String racingCarsNames) {

        List<Car> carArray =  new ArrayList<>();
        String[] carsNames = racingCarsNames.split(":");

        for (String carName : carsNames) {
            carArray.add(new Car(carName));
        }

        return carArray;
    }
}
