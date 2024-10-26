package racingcar;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class InputNames {
    List<String> names;

    public InputNames() {
        names = new ArrayList<>();
    }

    public List<String> input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        List<String> namelist = tokenize(input);
        return namelist;
    }

    public List<String> tokenize(String input) {
        List<String> namelist = new ArrayList<>();

        return namelist;
    }
}
