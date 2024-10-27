package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    private static final String PROMPT1 = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String PROMPT2 = "시도할 횟수는 몇 회인가요?";
    private static final String OUTPUT_HEADER  = "실행 결과";
    private static final String WINNER_HEADER = "최종 우승자 : ";
    private static Boolean check = false;

    public void displayPrompt(int num) {
        if (num == 1) {
            System.out.println(PROMPT1);
        } else {
            System.out.println(PROMPT2);
        }
    }

    public void displayRacing(List<Car> cars) {
        String result = "";

        if (!check) {
            result += OUTPUT_HEADER + "\n";
            check = true;
        }

        for (Car car : cars) {
            result += car.getName() + " : " + "-".repeat(car.getPosition()) + "\n";
        }

        System.out.println(result);
    }

    public void displayWinners(List<Car> winners) {
        String result = "";
        result += WINNER_HEADER;

        if (winners.size() == 1) {
            result += winners.get(0).getName();
        } else {
            String collect = winners.stream()
                    .map(Car::getName)
                    .collect(Collectors.joining(", "));
            result += collect;
        }
        System.out.print(result);
    }
}
