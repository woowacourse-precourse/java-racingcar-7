package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.List;

public class UI {
    private final Validation validation = new Validation();
    private final String GET_CAR_NAME_STATEMENT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String GET_ROUND_LIMIT_STATEMENT = "시도할 횟수는 몇 회인가요?";
    private final String PRINT_RESULT_STATEMENT = "실행 결과";
    private final String PRINT_WINNERS_STATEMENT = "최종 우승자 : ";
    public String[] getCarNames() {
        System.out.println(GET_CAR_NAME_STATEMENT);
        String input = Console.readLine();
        return validation.validateCarName(input);
    }

    public int getRoundLimit() {
        System.out.println(GET_ROUND_LIMIT_STATEMENT);
        String input = Console.readLine();
        return validation.validateRoundLimit(input);
    }

    public void printRoundResult(boolean isFirstRound, List<Car> participants) {
        if (isFirstRound) {
            System.out.println(PRINT_RESULT_STATEMENT);
        }
        for (Car car : participants) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getMovedCnt()));
        }
    }

    public void printWinners(List<String> winners) {
        System.out.println(PRINT_WINNERS_STATEMENT + String.join(", ", winners));
    }
}
