package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        //예외처리 1 추가예정 :이름 5자 초과

        System.out.println("시도할 횟수는 몇 회인가요?");
        String count_s = Console.readLine();
        int count = Integer.parseInt(count_s);
        //예외처리 2 추가예정: 횟수가 1회미만, 음수일경우
        //우승자 출력 추가예정
    }
}
