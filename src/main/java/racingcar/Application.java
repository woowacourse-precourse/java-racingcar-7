package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Application application = new Application();
        List<String> racers = application.getRacers();
        int totalRounds = application.getTotalOfRounds();

        Race race = new Race(racers);
        application.runRaceAndDisplayRacingResults(race, totalRounds);
    }

    protected List<String> getRacers() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        final String racersInput = Console.readLine();

        List<String> racers = Arrays.asList(racersInput.split(","));
        for (String racer : racers) {
            if (racer.isEmpty()) {
                throw new IllegalArgumentException("레이서 이름이 비었습니다.");
            }
            if (racer.length() > 5) {
                throw new IllegalArgumentException("레이서 이름은 5자 이하여야 합니다.");
            }
        }
        return racers;
    }

    protected int getTotalOfRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        final String totalOfRoundsInput = Console.readLine();

        return Integer.parseInt(totalOfRoundsInput);
    }

    protected void runRaceAndDisplayRacingResults(Race race, int totalRounds) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < totalRounds; i++) {
            race.moveAllCars();
            race.displayCarProgress();
            System.out.println();
        }

        displayWinners(race);
    }

    protected void displayWinners(Race race) {
        List<String> winners = race.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
