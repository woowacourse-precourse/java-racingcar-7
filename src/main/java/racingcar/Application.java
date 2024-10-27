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

        RacingCars racingCars = new RacingCars(new ArrayList<>());

        for (String name : names) {
            RacingCar racingCar = new RacingCar(name);
            racingCars.addRacingCar(racingCar);
        }

        List<RacingCar> racingCarList = racingCars.getRacingCars();

        for (int i = 0; i < roundCount; i++) {
            for (RacingCar racingCar : racingCarList) {
                int number = Randoms.pickNumberInRange(0, 10);
                racingCar.move(number);
            }

            for (RacingCar racingCar : racingCarList) {
                String positionMark = "-";
                String repeatedMark = positionMark.repeat(racingCar.getPosition());
                System.out.println(racingCar.getName() + " : " + repeatedMark);
            }
        }

        RacingCar winner = racingCarList.stream()
                .max(Comparator.comparingInt(RacingCar::getPosition))
                .orElseThrow(() -> new RuntimeException("Racing car does not exist"));

        List<String> winners = racingCarList.stream()
                .filter((racingCar) -> racingCar.getPosition() == winner.getPosition())
                .map(RacingCar::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static int inputRoundCount() {
        String count = Console.readLine();
        return Integer.parseInt(count);
    }

    private static List<String> inputNames() {
        String input = Console.readLine();
        return List.of(input.split(","));
    }
}
