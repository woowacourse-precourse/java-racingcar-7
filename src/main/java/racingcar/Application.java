package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" 메세지를 띄운다.
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        // 사용자에게 경주할 자동차 이름을 입력 받는다.
        final String carNamesInput = Console.readLine();
        // 입력받은 문자열이 `빈 문자열`인지 검사한다. (자동차 이름, 시도 횟수 모두)
        if (carNamesInput.isBlank()) {
            // 예외 처리: 입력 받은 문자열이 `빈 문자열`일 때 (자동차 이름, 시도 횟수 모두)
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        /*
          수정 대상
          컬렉션을 사용하고, Immutable 하게 만든다.
         */
        // 입력 받은 자동차 이름 문자열을 `쉼표(,)` 기준으로 분리한다.
        final String[] carNames = carNamesInput.split(",");
        for (String carName : carNames) {
            // 분리된 문자열이 `Blank` 인지 검사한다. (Console에 Null이 입력될 가능성은 없다.)
            if (carName.isBlank()) {
                // 예외 처리: 자동차 이름을 쉼표를 기준으로 분리한 후, `빈 문자열`일 때
                throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없습니다.");
            }
        }
    }
}
