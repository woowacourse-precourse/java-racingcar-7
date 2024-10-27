package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class IO {
    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int readNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printWinner(String winners) {
        System.out.print("최종 우승자 : " + winners);
    }
}
