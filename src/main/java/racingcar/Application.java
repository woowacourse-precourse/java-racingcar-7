package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceCount = Integer.parseInt(readLine());
        String[] carNames = carNamesInput.split(",");
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
        RacingController racingController = new RacingController(cars);
        System.out.println("실행 결과");
        for (int i = 0; i < raceCount; i++) {
            racingController.startRace();
            for (int j = 0; j < carNames.length; j++) {
                String raceRoundResult = cars[j].getName() + ":" + "-".repeat(cars[j].getForwardCount());
                System.out.println(raceRoundResult);
            }
            System.out.println();
        }
        WinnerDecider winnerDecider = new WinnerDecider(cars);
        System.out.println("최종 우승자 : " + winnerDecider.decideWinner());
        Console.close();
    }
}
