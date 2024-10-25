package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public void requireCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분)");
    }

    public void requireRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printCarPositions(Cars cars) {
        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            printCarPosition(car);
        }
        System.out.println();
    }

    private void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(Cars winnedCars) {
        List<String> winners = winnedCars.getCarList().stream()
            .map(Car::getName)
            .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    public void announceResult() {
        System.out.println("실행 결과");
    }
}
