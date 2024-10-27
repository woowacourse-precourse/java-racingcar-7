package racingcar.view;

import java.util.*;
import racingcar.global.io.Condition;
import racingcar.global.io.InputMessages;
import racingcar.model.Car;
import racingcar.model.Cars;

public class Input {
    public static Cars readCarName(){
        System.out.println(InputMessages.CAR_INPUT_MESSAGE);

        Scanner scanner = new Scanner(System.in);
        String carsInput = scanner.nextLine();
        List<Car> cars = carSaparator(carsInput);

        return new Cars(cars);
    }
    private static List<Car> carSaparator(String carsInput){
        String saparator = Condition.SAPARATOR;

        String[] carNames = carsInput.split(saparator);

        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }
}
