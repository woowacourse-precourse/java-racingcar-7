package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = new Race();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        race.setCars(Console.readLine());
        System.out.println("시도할 횟수는 몇 회인가요?");
        race.setTries(Console.readLine());
        System.out.println("\n실행 결과\n");
        List<String> winners = race.run();
        String result = "최종 우승자 : " + String.join(", ", winners);
        System.out.println(result);
    }
}
