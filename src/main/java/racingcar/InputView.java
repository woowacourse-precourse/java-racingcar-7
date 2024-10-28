package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] getCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉽표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public Integer getNum(){
        System.out.println("시도할 횟수는 몇 회 인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
