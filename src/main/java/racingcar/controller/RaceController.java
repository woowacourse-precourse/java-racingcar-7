package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.stream.ConsoleOutput;

import java.util.List;

public class RaceController {

    private final ConsoleOutput output = new ConsoleOutput();

    public void doRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = inputNames();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundCount = inputRoundCount();

        System.out.println();

        RacingCars racingCars = createRacingCars(names);
        runGame(roundCount, racingCars.getRacingCars());

        List<String> winners = findWinnersName(racingCars);

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private List<String> inputNames() {
        String input = Console.readLine();
        return List.of(input.split(","));
    }

    private int inputRoundCount() {
        String count = Console.readLine();
        return Integer.parseInt(count);
    }

    private RacingCars createRacingCars(List<String> names) {
        RacingCars racingCars = new RacingCars();

        for (String name : names) {
            RacingCar racingCar = new RacingCar(name);
            racingCars.addRacingCar(racingCar);
        }

        return racingCars;
    }

    private void runGame(int roundCount, List<RacingCar> racingCarList) {
        System.out.println("실행 결과");
        for (int i = 0; i < roundCount; i++) {
            startOneRace(racingCarList);
            outputRoundResult(racingCarList);
            System.out.println();
        }
    }

    private void startOneRace(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            int number = Randoms.pickNumberInRange(0, 10);
            racingCar.move(number);
        }
    }

    private void outputRoundResult(List<RacingCar> racingCarList) {
        for (RacingCar racingCar : racingCarList) {
            String positionMark = "-";
            String repeatedMark = positionMark.repeat(racingCar.getPosition());
            System.out.println(racingCar.getName() + " : " + repeatedMark);
        }
    }

    private List<String> findWinnersName(RacingCars racingCars) {
        int position = racingCars.findWinnerPosition();
        return racingCars.findNamesByPosition(position);
    }

}
