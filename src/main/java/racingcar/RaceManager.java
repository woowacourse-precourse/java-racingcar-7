package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceManager {
    public List<String> setRacer() {
        List<String> items = getRacerList();
        return items;
    }

    public int setRaceCycle() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycle;
        String cycleInput = Console.readLine();
        try {
            cycle = Integer.parseInt(cycleInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return cycle;
    }

    public void startRace(int cycle, List<RacingCar> racingCars) {
        for (int i = 0; i < cycle; i++) {
            System.out.println();
            printRaceStatus(racingCars);
        }
        System.out.println("최종 우승자 : "+getWinner(racingCars));

    }

    private static List<String> getRacerList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String string = Console.readLine();
        return Arrays.asList(string.split(","));
    }

    private static void printRaceStatus(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop();
            System.out.println(racingCar.getName() + " : " + racingCar.getStatusToDash());
        }
    }

    private static String getWinner(List<RacingCar> racingCars) {
        List<String> winners = new ArrayList<>();
        int maxScore = 0;

        for (RacingCar racingCar : racingCars) {
            int score = racingCar.getStatus();
            if (score > maxScore) {
                maxScore = score;
                winners.clear();
                winners.add(racingCar.getName());
            } else if (score == maxScore) {
                winners.add(racingCar.getName());
            }
        }
        return String.join(", ", winners);
    }
}
