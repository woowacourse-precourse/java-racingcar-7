package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 및 리스트 생성
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNamesArray = carNamesInput.split(",");
        InputValidator.validateCarNames(carNamesArray);

        List<Car> cars = Arrays.stream(carNamesArray)
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());

        // 시도 횟수 입력 및 유효성 검사
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptCount = Integer.parseInt(Console.readLine());
        InputValidator.validateAttemptCount(attemptCount);

        // 경주 게임 시작
        RaceGame raceGame = new RaceGame(cars, attemptCount);
        raceGame.startRace();

        // 우승자 결정 및 출력
        List<Car> winners = raceGame.getWinners();
        GamePrinter.printWinners(winners);
    }
}
