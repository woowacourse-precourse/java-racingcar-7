package racingcar;

import java.util.ArrayList;
import java.util.List;

class CarCollection {

    private List<Car> carList;

    public CarCollection() {
        this.carList = new ArrayList<>();
    }

    public void add(String carName) {
        Car newCar = new Car(carName);
        carList.add(newCar);
    }

    public List<String> getCarNames() {
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            carNames.add(car.getName());
        }
        return carNames;
    }

    public void moveCar(int index) {
        Car car = carList.get(index);
        car.move();
    }

    public int carCount() {
        return carList.size();
    }

    public List<Integer> getCarMoveCount() {
        List<Integer> carMoveCountList = new ArrayList<>();
        for (Car car : carList) {
            carMoveCountList.add(car.getMoveCount());
        }
        return carMoveCountList;
    }

    public List<String> getWinnerList() {
        int maxMoveCount = carList.stream()
            .mapToInt(car -> car.getMoveCount()).max().getAsInt();

        List<String> winners = carList.stream()
            .filter(car -> car.getMoveCount() == maxMoveCount)
            .map(car -> car.getName()).toList();

        return winners;
    }
}


