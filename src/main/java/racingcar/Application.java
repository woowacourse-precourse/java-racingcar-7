package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하시오.");
        String input = Console.readLine();

        List<Name> names = Name.createNames(input);
        for (Name name : names) {
            System.out.println(name.getName());
        }

    }
}
