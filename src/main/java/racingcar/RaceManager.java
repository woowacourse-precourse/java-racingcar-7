package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    public static final IOHandler IO_HANDLER = new IOHandler();

    public List<String> setupRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return IO_HANDLER.setRacerList();
    }

    public void startRace(List<RacingCar> racingCars) {
        int cycle = IO_HANDLER.setRaceCycle();
        for (int i = 0; i < cycle; i++) {
            System.out.println();
            displayRaceBroadcast(racingCars);
        }
        System.out.println("최종 우승자 : " + getWinner(racingCars));
    }

    private static void displayRaceBroadcast(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop();
            IO_HANDLER.printRaceState(racingCar);
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
        return String.join(",", winners);
    }
}