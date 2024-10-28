package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    private static ArrayList<String> CarName = new ArrayList<String>();
    private static int racingCounter;

    public static void initInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 필요함");
        }

        CarName.addAll(Arrays.asList(input.split(",")));
        for (String carName : CarName) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("이름 길이가 5 넘어감");
            }
            if (carName == null || carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름이 없음");
            }
        }


        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            racingCounter = Integer.parseInt(Console.readLine());
            if (racingCounter < 0) {
                throw new IllegalArgumentException("정수를 입력해야 함");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해야 함");
        }
    }

    public static ArrayList<String> getCarName() {
        return CarName;
    }

    public static int getRacingCounter() {
        return racingCounter;
    }
}
