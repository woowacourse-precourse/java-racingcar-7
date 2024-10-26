package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/*
 - [ ] 사용자는 몇 번의 이동을 할 것인지를 입력
 - [ ] 이름은 5자 이하만 가능하다.
 - [ ] 사용자가 잘못된 값을 입력할 경우 IlleagalArgumentException을 발생 시킨 후 애플리케이션 종료
 */
public class InputView {
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String userInput = Console.readLine();

        return userInput.split(",");
    }
}
