package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = inputNames();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundCount = inputRoundCount();

        System.out.println();

        List<RacingCar> racingCarList = createRacingCars(names);
        runGame(roundCount, racingCarList);

        List<String> winners = findWinnersName(racingCarList);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<String> inputNames() {
        String input = Console.readLine();
        return List.of(input.split(","));
    }

    private static int inputRoundCount() {
        String count = Console.readLine();
        return Integer.parseInt(count);
    }

    private static List<RacingCar> createRacingCars(List<String> names) {
        RacingCars racingCars = new RacingCars();

        for (String name : names) {
            RacingCar racingCar = new RacingCar(name);
            racingCars.addRacingCar(racingCar);
        }

        return racingCars.getRacingCars();
    }

    private static void runGame(int roundCount, List<RacingCar> racingCarList) {
        System.out.println("실행 결과");
        for (int i = 0; i < roundCount; i++) {
            startOneRace(racingCarList);
            outputRoundResult(racingCarList);
            System.out.println();
        }
    }

    private static void startOneRace(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int number = Randoms.pickNumberInRange(0, 10);
            racingCar.move(number);
        }
    }

    private static void outputRoundResult(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            String positionMark = "-";
            String repeatedMark = positionMark.repeat(racingCar.getPosition());
            System.out.println(racingCar.getName() + " : " + repeatedMark);
        }
    }

    private static List<String> findWinnersName(List<RacingCar> racingCarList) {
        RacingCar firstWinner = findFirstWinner(racingCarList);
        return findCoWinnersName(racingCarList, firstWinner);
    }

    private static RacingCar findFirstWinner(List<RacingCar> racingCarList) {
        return racingCarList.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .orElseThrow(() -> new RuntimeException("Racing car does not exist"));
    }

    private static List<String> findCoWinnersName(List<RacingCar> racingCarList, RacingCar firstWinner) {
        return racingCarList.stream()
                .filter((racingCar) -> racingCar.getPosition() == firstWinner.getPosition())
                .map(RacingCar::getName)
                .toList();
    }
}
