package racingcar.view;

import racingcar.domain.Car;

import java.util.Comparator;
import java.util.List;

public class OutputView {

    public void resultText() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void resultPerOneCircle(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void winners(List<Car> carList) {
        int maxDistance = getMaxDistance(carList);

        List<String> winnerList = carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();

        String winners = String.join(", ", winnerList);

        System.out.print("최종 우승자 : " + winners);
    }


    public int getMaxDistance(List<Car> carList) {
        return carList.stream()
                .max(Comparator.comparingInt(Car::getDistance))
                .get().getDistance();
    }
}
