package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] names = Console.readLine().split(",");
        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();
        System.out.println("\n실행 결과");

        Race race = new Race();
        race.raceStart(names, count);
    }
}
