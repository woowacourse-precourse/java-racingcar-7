package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        try {
            String[] carNames = inputCarNames();
            int raceCount = inputRaceCount();
            RacingController racingController = new RacingController(carNames);
            racingController.progressRace(raceCount);
            WinnerDecider winnerDecider = new WinnerDecider(racingController.getCars());
            winnerDecider.decideWinner();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        for (String carName : carNames){
            if (carName.length() > 5){
                throw new IllegalArgumentException("[ERROR] 자동차 이름은 5자 이하만 가능합니다.");
            }
        }
        return carNames;
    }

    public static int inputRaceCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceCount = Integer.parseInt(readLine());
        return raceCount;
    }
}
