package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceManager {
    public static final IOHandler IO_HANDLER = new IOHandler();

    public List<String> getRacerList() {
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

        int maxScore = 0;
        List<String> winners = new ArrayList<>();
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
        return IO_HANDLER.getWinerList(winners);
    }
}