package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String str = Console.readLine();
        return carValidation(str);
    }

    public String carValidation(String str) {
        for (String s : str.split(",")) {
            String name = s.trim();
            if (name.length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException("올바르지 않은 문자열 입력입니다. (5자 이하 입력)");
            }
        }
        return str;
    }


    public int inputRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int number = Integer.parseInt(Console.readLine());
        System.out.println("\n실행 결과");
        return roundValidation(number);
    }

    public int roundValidation(int number) {
        if (number > 0) {
            return number;
        }
        throw new IllegalArgumentException("올바르지 않은 횟수입니다.(0 이상 입력)");
    }
}