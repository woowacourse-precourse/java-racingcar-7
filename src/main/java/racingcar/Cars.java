package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> nameList) {
        this.carList = setCarList(nameList);
    }

    private List<Car> setCarList(List<String> nameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : nameList) {
            carList.add(new Car(name, 0));
        }
        return carList;
    }

    public void moveAll() {
        carList.forEach(Car::forwardOrStop);
    }

    // 가장 큰 forwardCnt를 찾은 후, 해당 값과 같은 모든 차의 이름을 리스트로 반환한다.
    public List<String> findWinnersName() {
        int maxForwardCnt = carList.stream()
                .mapToInt(car -> car.forwardCnt)
                .max()
                .orElse(-1);

        return carList.stream()
                .filter(car -> car.forwardCnt == maxForwardCnt)
                .map(car -> car.name)
                .toList();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(Car car : carList){
            str.append(car.toString()).append("\n");
        }
        return str.toString();
    }
}
