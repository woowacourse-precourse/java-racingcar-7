package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }

        String[] names = input.split(",");
        List<String> nameList = new ArrayList<>();
        for (String name : names) {
            String trim_name = name.trim(); // 이름 양 끝 공백 제거
            if (trim_name.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (nameList.contains(trim_name)) {
                throw new IllegalArgumentException();
            } else {
                nameList.add(trim_name);
            }
        }

    }
}
