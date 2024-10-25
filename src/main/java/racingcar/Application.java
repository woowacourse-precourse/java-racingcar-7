package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    static void splitCarInput(String carName) {
        List<String> members = Arrays.asList(carName.split(","));
        chkCarName(members);
    }

    static void chkCarName(List carNameList) {
        for (int i = 0; i < carNameList.size(); i++) {
            String carName = carNameList.get(i).toString();
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름이 5글자 초과입니다.");
            } else if (carName.length() == 0) {
                throw new IllegalArgumentException("이름이 0글자 입니다.");
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        splitCarInput(carNameInput);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int playNum = Integer.parseInt(Console.readLine());

    }
}
