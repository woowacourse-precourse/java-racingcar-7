package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");

        Exception exception = new Exception();
        exception.except1(names);
        exception.except2(names);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count_s = Console.readLine();
        exception.except3(count_s);
        int count = Integer.parseInt(count_s);


        Racing racing=new Racing();
        racing.race(names,count);
    }
}
