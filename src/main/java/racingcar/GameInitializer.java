package racingcar;

import java.util.ArrayList;

public class GameInitializer {
    private ArrayList<Car> cars = new ArrayList<>();

    public void gameInitialize(String[] names) {
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void longestCarName(ArrayList<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        ArrayList<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
