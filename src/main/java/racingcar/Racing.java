package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {

    private String inputName;
    private List<String> carNames;

    public Racing() {
        carNames = new ArrayList<>();
    }

    public int input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputName = Console.readLine();
        carNames = Arrays.asList(tokenization());
        System.out.println(carNames);
        System.out.println("시도할 횟수는 몇 회 인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

    }

    private String[] tokenization(){
        String[] names = inputName.split(",");
        validateNameLength(names);
        return names;
    }

    private void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해야 합니다.");
            }
        }
    }


    // 결과 출력
}
