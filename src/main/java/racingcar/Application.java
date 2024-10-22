package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final OngoingValueGenerator ongoingValueGenerator = new OngoingValueGenerator();

    public static void main(String[] args) {
        String[] carNames = inputCarNames();
        Cars cars = new Cars(carNames);
        int round = inputRound();
        RacingGame racingGame = new RacingGame(ongoingValueGenerator, cars, round);
        while (!racingGame.isFinished()) {
            racingGame.progress();
            List<Car> currentCars = racingGame.getCars();
            printCarsStatus(currentCars);
        }
        List<Car> winners = racingGame.getWinners();
        printWinners(winners);
    }

    private static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCars = Console.readLine();
        return inputCars.split(",");
    }

    private static int inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputRound = Console.readLine();
        return Integer.parseInt(inputRound);
    }

    private static void printCarsStatus(List<Car> cars) {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars) {
            printCar(car);
        }
    }

    private static void printCar(Car car) {
        System.out.println("%s : %s".formatted(car.getName(), positionBar(car.getPosition())));
    }

    private static String positionBar(int position) {
        return "-".repeat(position);
    }

    private static void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println();
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
