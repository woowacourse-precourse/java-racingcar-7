package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {
    private static String inputNameString(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int inputNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public static List<String> getNameList(){
        String inputNameString = inputNameString();

        if (!inputNameString.contains(",")) {
            throw new IllegalArgumentException("쉼표 기준으로 구분해주세요.");
        }

        String[] nameList = inputNameString.split(",");
        return List.of(nameList);
    }
}
