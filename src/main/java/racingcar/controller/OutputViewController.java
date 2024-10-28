package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.view.OutputView;

public class OutputViewController {
    private OutputView outputView = new OutputView();

    public void printRace(List<Car> cars) {
        for (Car car : cars) {
            outputView.printRaceProcedure(car.getName(), drewBar(car.getDistance()));
        }
        System.out.println();
    }

    // 우승자의 Car리스트를 출력하기 위해 자동차 이름들을 문자열 형태로 join하여 출력
    public void printWinner(List<Car> cars) {
        String winnersName = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        outputView.printWinnerNames(winnersName);
    }

    // 자동차의 이동 거리를 bar로 나타내기 위해 거리만큼 bar를 더해서 반환
    private String drewBar(int distance) {
        return "-".repeat(distance);
    }
}
