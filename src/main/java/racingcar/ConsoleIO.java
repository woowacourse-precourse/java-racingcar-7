package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class ConsoleIO {

    private String readNonEmptyLine() {
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        }
        return input;
    }

    public HashMap<String, String> input() {
        HashMap<String, String> inputData = new HashMap<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputData.put("carNames", readNonEmptyLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        inputData.put("attempts", readNonEmptyLine());

        Console.close();
        return inputData;
    }

    public void output(List<String> outputData) {
        System.out.println("\n실행 결과");
        for (String data : outputData) {
            System.out.println(data + "\n");
        }
    }
}
