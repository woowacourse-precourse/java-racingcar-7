package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private final static String RESULT_MESSAGE = "실행 결과";

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarStates(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
    }

    public void printResult(List<Car> winnerList){
        System.out.print("최종 우승자 : ");
        String winners = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winners);
    }

}
