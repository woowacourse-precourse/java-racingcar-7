package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String cars = Console.readLine();
        String move_cnt = Console.readLine();
    }
    public static ArrayList<Car> add_cars(String cars) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String car_name : cars.split(",")) {
            validate(car_name);
            carList.add(new Car(car_name, 0));
        }
        return carList;
    }
    public static void validate(String car_name) {
        if(car_name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
