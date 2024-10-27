package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceManager {

    private ArrayList<Car> cars = new ArrayList<>();

    public void setCarName(String input) {
        List<String> carName;
        try {
            carName = Arrays.asList(input.replace(" ", "").split(","));
            NameValidator.carNameLengthChecker(carName);
            for (String name : carName) {
                Car car = new Car();
                car.nameCar(name);
                cars.add(car);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(); // exception
        }
    }

    public void showProgressOfGame() {
        for (Car car : cars) {
            car.printForwardLevel();
        }
    }

    public ArrayList<Car> getCarList() {
        return cars;
    }

    public ArrayList<String> selectChampion() {
        ArrayList<String> championList = new ArrayList<>();
        int bestScore = 0;
        for (Car car : cars) {
            int carForwardLevel = car.getForwardLevel();
            if (carForwardLevel > bestScore) {
                championList.clear();
                championList.add(car.getCarName());
                bestScore = carForwardLevel;
            } else if (carForwardLevel == bestScore) {
                championList.add(car.getCarName());
            }
        }
        return championList;
    }

    public void showChampion() {
        ArrayList<String> championList = selectChampion();
        System.out.print("최종 우승자 : ");
        int championListSize = championList.size();
        for (int i = 0; i < championListSize; i++) {
            if (i < championListSize - 1) {
                System.out.print(championList.get(i) + ", ");
            }
            if (i == championListSize - 1) {
                System.out.print(championList.get(i));
            }
        }
    }

    public void doRacing() {
        for (Car car : cars) {
            if (car.isForward()) {
                car.forward();
            }
        }
        showProgressOfGame();
        System.out.println();
    }

}
