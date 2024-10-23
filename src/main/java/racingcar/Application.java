package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws CarNameInputException{
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<Car> cars = createParticipant(input);

        for (Car car : cars) {
            System.out.println(car.getCarName());
        }
    }

    public static List<Car> createParticipant(String input) {

        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            name = name.trim();
            if (name.isEmpty() || name.length() > 5) {
                throw new CarNameInputException();
            }
            cars.add(new Car(name));
        }

        return cars;
    }
}