package racingcar.model;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();

    public Cars(String[] carNames){
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void playRound(int tryCount){
        while (tryCount > 0) {
            moveCarsWithRandomCondition();
            tryCount = tryCount - 1;
        }
    }

    private void moveCarsWithRandomCondition() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public List<String> getResults(){
        List<String> results = new ArrayList<>();
        for (Car car: cars) {
            results.add(car.getResult());
        }
        return results;
    }

    public List<String> getWinners() {
        int maxForward = cars.stream()
                .mapToInt(Car::getForward)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("최대값을 찾을 수 없습니다."));

        return cars.stream()
                .filter(car -> car.getForward() == maxForward)
                .map(Car::getName)
                .toList();
    }

}
