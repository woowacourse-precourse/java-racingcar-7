package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void getCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine().trim();

        if(input.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다.");
        }
    }
 }
