package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class ConsoleIo {
    private static final String NAME_INPUT_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String COUNT_INPUT_MSG = "시도할 횟수는 몇 회인가요?";
    private static final String OUTPUT_MSG = "실행 결과";

    public String getNameInput() {
        System.out.println(NAME_INPUT_MSG);
        return Console.readLine();
    }

    public String getCountInput() {
        System.out.println(COUNT_INPUT_MSG);
        return Console.readLine();
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(OUTPUT_MSG);
    }

    public void printEachResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(", ", winner));
    }
}
