package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] carNames = getCarNames();
        Integer attempts = getNumberOfAttempts();
        List<StringBuilder> raceResults = initializeRaceResults(carNames);
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
