package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();

        String[] names = inputName.split(",");

        for (String name : names){
            if (name.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputCount = Integer.parseInt(Console.readLine());

    }
}
