package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.exception.InputException;
import racingcar.validator.InputValidator;

import java.util.List;

public class InputView{
    public List<String> InputNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        try{
            return InputValidator.parseNames(names);
        } catch (InputException e){
            throw new IllegalArgumentException();
        }
    }

    public int InputTurns() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberString = Console.readLine();
        try{
            return InputValidator.parseTurns(numberString);
        } catch(InputException e){
            throw new IllegalArgumentException();
        }

    }


}
