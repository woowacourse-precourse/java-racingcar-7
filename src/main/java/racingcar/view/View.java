package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.io.IOException;

public class View {
    private final String CARNAME_SEPARATOR = ",";

    public String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return parseNames(Console.readLine());
    }

    public Integer inputRepeatCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        return parseRepeatCount(Console.readLine());
    }

    public void printOutput(String output) {
        System.out.println(output);
    }

    public String[] parseNames(String input) {
        String[] nameList = input.split(CARNAME_SEPARATOR);
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
        return nameList;
    }

    public Integer parseRepeatCount(String input) {
        Integer repeatCount;
        try {
            repeatCount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return repeatCount;
    }
}
