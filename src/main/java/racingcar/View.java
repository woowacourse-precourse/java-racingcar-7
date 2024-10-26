package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class View {
    /*
    클래스 변수, 상수

    인스턴스 변수

    생성자
     */
    static final int MAX_NAME = 5;

    private String userInput() {
        return Console.readLine().trim();
    }

    public List<String> inputCarNames(String input) {
        String[] names = input.split(",");
        for (int i =0 ; i<names.length; i++) {
            names[i] = names[i].trim();
            isVaildNameMax(names[i]);
        }
        return Arrays.asList(names);
    }

    private void isVaildNameMax(String name) {
        if (name.length() > MAX_NAME || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 입력해주세요.");
        }
    }
}
