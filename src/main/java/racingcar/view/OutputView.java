package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private final String WINNER_PROMPT = "최종 우승자 : ";
    private final String RESULT_PROMPT = "실행 결과";

    public void printResultPrompt() {
        System.out.println("\n" + RESULT_PROMPT);
    }

    public void printCurrentPosition(List<Car> cars) {
        for (Car car : cars) {
            String position = "-".repeat(car.currentPosition());
            System.out.println(car.getName() + " : " + position);
        }
        System.out.println();
    }


    public void printWinner(List<String> winners){
        System.out.print(WINNER_PROMPT+String.join(",",winners));
    }
}
