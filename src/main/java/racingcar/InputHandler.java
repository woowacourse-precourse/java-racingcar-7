package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {
    String input;
    List<String> names;
    Integer runCount;

    public void inputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.input = Console.readLine();
        this.names = InputHandler.commaSeparator(input);
    }

    public void inputCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        this.runCount = Integer.parseInt(Console.readLine());
    }

    public static List<String> commaSeparator(String input){
        List<String> names = List.of(input.split(","));
        return names;
    }
}
