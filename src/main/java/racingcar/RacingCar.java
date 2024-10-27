package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class RacingCar {


    public static String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static int inputTrial() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

    }

    public static String[] splitInputCarNames(String inputCarNames) {
        return inputCarNames.split(",");
    }

    public static void checkInputCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5 || carName.isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }


}