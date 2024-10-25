package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.RacingGame;
import racingcar.domain.car.Car;
import racingcar.domain.car.Condition;
import racingcar.domain.car.RandomNumberGenerator;
import racingcar.domain.round.RoundResult;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = Arrays.stream(Console.readLine().split(",")).toList();
        List<Car> cars = carNames.stream()
                .map(carName -> new Car(carName, new Condition(new RandomNumberGenerator())))
                .toList();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int finalRound = Integer.parseInt(Console.readLine());

        RacingGame racingGame = new RacingGame(cars, finalRound);

        System.out.println("\n실행 결과");
        while (racingGame.isNotGameOver()) {
            racingGame.playNextRound();
            for (RoundResult roundResult : racingGame.getRacingResult()) {
                System.out.println(roundResult.carName() + " : " + "-".repeat(roundResult.position()));
            }
            System.out.println();
        }
        List<String> finalWinners = racingGame.getFinalWinners();

        System.out.println("최종 우승자 : " + String.join(",", finalWinners));
    }

}
