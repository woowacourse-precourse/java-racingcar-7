package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + "\n");
        String CarNameList = Console.readLine();
        System.out.print("시도할 횟수는 몇 회인가요?" + "\n");
        String Attempt = Console.readLine();

        System.out.print(CarNameList + "\n");
        System.out.print(Attempt + "\n");

    }
}
