package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public static final String EXECUTION_RESULT_HEADER = "실행 결과";
    public static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void printExecutionResultHeader() {
        System.out.println("\n"+EXECUTION_RESULT_HEADER);
    }

    public void printExecutionStatus(List<Car> cars) {
        cars.forEach((car) -> System.out.println(car.getName() + " : " + "-".repeat(car.getStatus())));
        System.out.println();
    }

    public void printFinalWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }

}
