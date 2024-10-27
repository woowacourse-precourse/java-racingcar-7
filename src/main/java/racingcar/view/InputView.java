package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator.InputValidator;


public class InputView {
    public static String readString() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();
        InputValidator.checkEmptyInput(inputString); 
        if (!InputValidator.checkInputFormat(inputString) || !InputValidator.checkInputRule(inputString)) {
            throw new IllegalArgumentException("입력이 잘못되었습니다");
        }
        return inputString;
    }


    public static int readNumber(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputNum = Console.readLine();
        if(!InputValidator.isNumber(inputNum)){
            throw new IllegalArgumentException("입력이 잘못되었습니다");
        }
        return Integer.parseInt(inputNum);
    }

}
