package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputHandler {
    private String input;
    private List<String> names;
    private int runCount;

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
        for(String name : names){
            if(name.trim().isEmpty()){
                throw new IllegalArgumentException("이름이 비었습니다.");
            }
            if(name.length() > 5){
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return names;
    }

    public Integer getRunCount() {
        return runCount;
    }

    public List<String> getNames() {
        return names;
    }
}
