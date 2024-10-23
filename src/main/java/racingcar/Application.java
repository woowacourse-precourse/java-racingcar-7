package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

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
    public static ArrayList<Car> race_start(String cars, String move_cnt) {
        ArrayList<Car> carList = add_cars(cars);
        int move_time = Integer.parseInt(move_cnt);
        while(move_time-- > 0) {
            carList = move_car(carList);
        }
        return carList;
    }
    public static ArrayList<Car> move_car(ArrayList<Car> carList) {
        for(Car car : carList) {
            if(Randoms.pickNumberInRange(0,9) >= 4) {
                car.setDistance(car.getDistance() + 1);
            }
        }
        return carList;
    }
}
