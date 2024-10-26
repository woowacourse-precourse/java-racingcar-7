package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.util.InputCarsValidator;
import racingcar.util.RaceCountValidator;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        InputCarsValidator.isEmpty(input);

        List<Car> cars = Arrays.stream(input.split(",", -1))
                .map(Car::new)
                .toList();

        InputCarsValidator.hasDuplicate(cars);

        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();

        RaceCountValidator.validate(count);
        int raceCount = Integer.parseInt(count);

        System.out.println("\n실행 결과");
        List<Car> gameResult = printRaceResult(cars, raceCount);

        String winners = compareWinnerMoveCount(gameResult);
        printWinner(winners);
    }

    private static void printWinner(String winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(winners);
    }

    private static List<Car> printRaceResult(List<Car> cars, int playCount) {

        for (int i = 0; i < playCount; i++) {
            move(cars);
            printRaceProgress(cars);
            System.out.println();
        }

        return cars;
    }

    private static void move(List<Car> cars) {
        for (Car car : cars) {
            if (checkMove()) {
                car.addMoveCount();
            }
        }
    }

    private static void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            convertIntRealMove(car.getMoveCount());
            System.out.println();
        }
    }

    private static void convertIntRealMove(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
    }

    private static boolean checkMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }

    private static String compareWinnerMoveCount(List<Car> gameResult) {

        int maxValue = gameResult.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .getAsInt();

        List<Car> winners = gameResult.stream()
                .filter(car -> maxValue == car.getMoveCount())
                .toList();

        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));

    }


}
