package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String string = Console.readLine();
        String[] carList = string.split(",");

        int count = 0;
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : carList) {
            count++;
            RacingCar newRacingCar = new RacingCar(carName);
            racingCars.add(newRacingCar);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int cycle;
        String cycleInput = Console.readLine();
        try {
            cycle = Integer.parseInt(cycleInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < cycle; i++) {
            System.out.println();
            System.out.println(count + "차");
            startRace(racingCars);
        }
        String winnerNames = getWinner(racingCars);
        System.out.println("최종 우승자: " + winnerNames);

    }

    private static void startRace(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveOrStop();
            System.out.println(racingCar.getName()+" : "+racingCar.getStatus());
        }
    }
    private static String getWinner(List<RacingCar> racingCars) {
        List<String> winners = new ArrayList<>();
        int maxScore = Integer.MIN_VALUE;

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
