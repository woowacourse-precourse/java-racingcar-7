package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int MAX_NAME_LENGTH = 5;

    public static void main(String[] args) {
        try {
            String[] carNames = getCarNames();
            int attempts = getNumberOfAttempts();
            List<StringBuilder> raceResults = initializeRaceResults(carNames);

            runRace(attempts, carNames, raceResults);
            determineWinners(carNames, raceResults);

        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private static void runRace(int attempts, String[] carNames, List<StringBuilder> raceResults) {
        System.out.println("실행 결과");
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

    private static void determineWinners(String[] carNames, List<StringBuilder> raceResults) {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (StringBuilder result : raceResults) {
            if (result.length() > maxDistance) {
                maxDistance = result.length();
            }
        }

        for (int i = 0; i < raceResults.size(); i++) {
            if (raceResults.get(i).length() == maxDistance) {
                winners.add(carNames[i]);
            }
        }

        displayWinners(winners);
    }

    private static void displayWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (String winner : winners) {
            System.out.print(winner + ",");
        }
    }

    private static String[] getCarNames(){
        System.out.println("경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();

        if (carNamesInput == null || carNamesInput.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }

        String[] carNames = carNamesInput.split(",");
        for (String carName : carNames) {
            if (carName.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은" + MAX_NAME_LENGTH + "자 이하만 가능 합니다.");
            }
        }

        return carNames;
    }

    public static int getNumberOfAttempts() {
        System.out.println("시도할 횟수를 입력하세요.");
        String input = Console.readLine();

        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("횟수는 비어있을 수 없습니다.");
        }

        int numberOfAttempts;
        try {
            numberOfAttempts = Integer.parseInt(input);
            if (numberOfAttempts <= 0) {
                throw new IllegalArgumentException("횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력해야 합니다.");
        }

        return numberOfAttempts;
    }

    private static List<StringBuilder> initializeRaceResults(String[] carNames){
        List<StringBuilder> raceResults = new ArrayList<>();
        for (String carName : carNames) {
            raceResults.add(new StringBuilder());
        }
        return raceResults;
    }
}
