package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int number = Integer.parseInt(Console.readLine());

        InputProcess inputProcess = new InputProcess();
        String[] carList = inputProcess.splitName(carNames);
        inputProcess.checkName(carList);

        int[] winnerCount = new int[carList.length];
        Racing racing = new Racing();
        Winner winner = new Winner();
        for (int i = 0; i < number; i++) {
            int[] racingResult = racing.racing(carList, number);
            winner.checkWinner(racingResult, winnerCount);
        }
        System.out.print("최종 우승자 : ");
        winner.printFinalWinner(carList, winnerCount);
    }
}
