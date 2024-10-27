package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("자동차 이름을 쉼표(,)로 구분하여 입력해 주세요.");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int attemptsNum = Integer.parseInt(Console.readLine());

        Console.close();
    }
}