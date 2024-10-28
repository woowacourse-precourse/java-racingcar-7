package racingcar;

import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> names) {
        this.carList = names.stream()
                .map(name -> new Car(name, 0))
                .toList();
    }

    public void moveAll() {
        carList.forEach(Car::move);
    }

    public List<String> findWinner() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("리스트가 비어 있습니다"));

        List<String> winnerList = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        return winnerList;
    }

    public List<Car> getCarList() {
        return carList;
    }
}
