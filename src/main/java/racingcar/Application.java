package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int try_count = Integer.parseInt(Console.readLine());

        String[] cars = input.split(",");

        GameManager gameManager = new GameManager();

        String[] winners = gameManager.StartGame(cars, try_count);

        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winners.length - 1; i++) {
            System.out.print(winners[i] + ", ");
        }
        System.out.print(winners[winners.length - 1]);
    }
}
