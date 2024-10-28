package racingcar.io;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Car;

public class OutputHandler {
    // TODO: 최종 우승자 출력하기
    //    - 가장 많이 이동한 자동차가 우승한다.
    //    - 자동차 경주 게임을 완료한 후 최종 우승자 안내 문구를 출력한다.
    //    - 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.

    private List<Car> cars;

    public OutputHandler(List<Car> cars) {
        this.cars = cars;
    }

    public void printTrialResult() {
        System.out.println("실행 결과");
        for (Car car : this.cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printFinalWinner() {
        List<String> winners = getFinalWinner();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public List<String> getFinalWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
