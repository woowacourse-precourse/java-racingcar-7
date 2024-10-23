package racingcar;

import camp.nextstep.edu.missionutils.Console;

// 2. 시도할 횟수를 입력 받는다.
//    * 횟수가 숫자인지 검증한다.
// 3. 시도 횟수만큼 경주를 반복하고, 횟수별 경주 결과를 출력한다.
// 4. 경주마다 자동차별 0~9 사이 무작위 값을 구한 후, 값이 4 이상이면 전진한다.
// 5. 마지막 경주 이후 최종 우승자를 출력한다.
//    * 단독 우승자와 공동 우승자로 내용을 구분하여 출력한다.
//    * 공동 우승자일 경우 쉼표(,)를 이용하여 구분한다.
public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names = input.split(",");
        if (names.length == 0) {
            throw new IllegalArgumentException("이름은 쉼표(,) 기준으로 구분하여 입력해주세요.");
        } // end if

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해주세요.");
            } // end if
        } // end for

        String inputTimes = Console.readLine();
        if (!inputTimes.matches("^[0-9]+$")) {
//            throw new NumberFormatException("숫자를 입력해주세요.");
            throw new IllegalArgumentException("시도 횟수는 숫자만 입력 가능합니다.");
        } // end if
        int times = Integer.parseInt(inputTimes);
    } // main
} // class