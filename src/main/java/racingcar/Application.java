package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String carNameText;
        int tryNum;

        System.out.println("경주할 자동차 이름을 입력하세요.");
        carNameText = Console.readLine();
        System.out.println("횟수를 입력하세요.");
        tryNum = Integer.parseInt(Console.readLine());
    }


}
