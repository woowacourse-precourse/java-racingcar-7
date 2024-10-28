package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        String inputNames;
        int moves;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputNames = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        moves = Integer.parseInt(Console.readLine());

        try {
            Race race = new Race(inputNames, moves);
            System.out.println("\n실행 결과");
            race.startRace();
            race.displayWinners();
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
            throw e; // 예외를 다시 던져 테스트에서 확인할 수 있도록 함
        }

    }
}
