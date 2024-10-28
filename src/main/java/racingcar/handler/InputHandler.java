package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputHandler {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return List.of(Console.readLine().split(","));
    }

    public int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }catch(NumberFormatException n){
            throw new IllegalArgumentException("숫자 이외에 수를 입력하지 마세요.");
        }
    }
}