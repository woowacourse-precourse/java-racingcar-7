package racingcar;

import racingcar.model.Car;
import racingcar.model.Dice;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static final Dice dice = new Dice();

    public static void main(String[] args) {
        List<Car> raceCars = getCarNames();
        Integer attempt = getAttempt();

        startGame(raceCars, attempt);
        List<Car> winnerCar = findWinner(raceCars);
        printWinner(winnerCar);
    }

    private static List<Car> getCarNames() {
        List<Car> raceCars = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String allMembers = Console.readLine();
        String[] carNames = allMembers.split(",");

        if (allMembers.equals("") || allMembers.trim().isEmpty()) {
            throw new IllegalArgumentException("참여하는 자동차가 없습니다.");
        }

        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("이름은 5글자 이하로 설정해야 합니다.");
            }
            raceCars.add(new Car(name.trim()));
        }
        return raceCars;
    }

    private static Integer getAttempt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Integer attempt = Integer.valueOf(Console.readLine());

        if (attempt <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1이상으로 설정해야 합니다.");
        }

        return attempt;
    }

    public static void startGame(List<Car> raceCars, Integer attempt) {
        System.out.println();
        System.out.println("실행 결과");

        for (int attemptNum = 0; attemptNum < attempt; attemptNum++) {
            runRaceRound(raceCars);
            printRaceRoundProgress(raceCars);
        }
    }

    private static void runRaceRound(List<Car> raceCars) {
        for (Car car : raceCars) {
            if (dice.roll() >= 4) {
                car.moveOneStep();
            }
        }
    }

    public static void printRaceRoundProgress(List<Car> raceCars) {
        for (Car car : raceCars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private static List<Car> findWinner(List<Car> raceCars) {
        int maxPosition = raceCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Car list is empty"));

        return raceCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private static void printWinner(List<Car> winnerCar) {
        String winner = winnerCar.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winner);
    }
}
