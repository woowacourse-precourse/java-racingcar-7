package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.util.Validator;

public class GameView {

    public List<String> getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        if(Validator.isEmptyInput(input)) {
            throw new IllegalArgumentException();
        }

        List<String> cars = List.of(input.split(","));

        Validator.validateCarName(cars);

        return cars;
    }

    public int getAttemptCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String input = Console.readLine();

        Validator.validateAttemptCount(input);

        return Integer.parseInt(input);
    }
    
    public void displayBeforeGameProcess() {
        System.out.println("실행 결과\n");
    }

    public void displayRoundResult(String roundResult) {
        System.out.println(roundResult);
    }

    public void displayWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                                    .map(Car::getName)
                                    .reduce((a,b) -> a + ", " + b)
                                    .orElse("");

        System.out.println("최종 우승자 : " + winnerNames);
    }

}
