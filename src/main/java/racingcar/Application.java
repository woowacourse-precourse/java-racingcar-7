package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 메세지를 띄운다.
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 사용자에게 경주할 자동차 이름을 입력 받는다.
        final String carNamesInput = Console.readLine();

        /*
          수정 대상
          컬렉션을 사용하고, Immutable 하게 만든다.
         */
        // 입력 받은 자동차 이름 문자열을 `쉼표(,)` 기준으로 분리한다.
        final String[] carNames = carNamesInput.split(",");
    }
}
