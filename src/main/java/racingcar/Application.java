package racingcar;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력 및 검증
        List<String> nameList = inputCarNames();
    }

    private static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = readLine();
        List<String> nameList = Arrays.asList(names.split(","));
        for (String name : nameList) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return nameList;
    }
}