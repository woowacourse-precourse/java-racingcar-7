package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
        Integer attempts = getNumberOfAttempts();
        List<StringBuilder> raceResults = initializeRaceResults(carNames);

        runRace(attempts, carNames, raceResults);
    }

    private static void runRace(int attempts, String[] carNames, List<StringBuilder> raceResults) {
        System.out.println("실행 결과");
        Integer carNamesLength = carNames.length;
        for (int i = 0; i < attempts; i++) {
            updateAndDisplayRaceResults(carNames, raceResults);
        }
    }

    private static void updateAndDisplayRaceResults(String[] carNames, List<StringBuilder> raceResults) {
        int carNamesLength = carNames.length;
        for (int i = 0; i < carNamesLength; i++) {
            StringBuilder nowRaceCarResult = raceResults.get(i);
            if (Randoms.pickNumberInRange(0, 9) >= 4) { // 4 이상일 때 전진
                nowRaceCarResult.append("-");
            }
            System.out.println(carNames[i] + " : " + nowRaceCarResult);
        }
    }

    private static String[] getCarNames(){
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        return carNamesInput.split(",");
    }

    private static int getNumberOfAttempts(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private static List<StringBuilder> initializeRaceResults(String[] carNames){
        List<StringBuilder> raceResults = new ArrayList<>();
        for (String carName : carNames) {
            raceResults.add(new StringBuilder(carName));
        }
        return raceResults;
    }
}
