package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {


    public static String[] inputCar() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String carName = Console.readLine().replaceAll("\\s+","");

        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력하세요.");
        }

        String[] carNames = carName.split(",");

        for (String name : carNames) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 글자 수가 초과하였습니다.");
            }
        }

        return carNames;
    }

    public static int inputCount (){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCountNum = Console.readLine();

        try {
            return Integer.parseInt(inputCountNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하세요.");
        }

    }
}
