package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(readLine());
        System.out.println("names = " + names);
        System.out.println("tryCount = " + tryCount);
    }
}
