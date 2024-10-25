package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputVIew {
    private final Validator validator = new Validator();

    public String [] getInput(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return validator.validate(input);
    }


    public int getCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
