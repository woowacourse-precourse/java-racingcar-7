package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class RacingCar {

    public static String[] input() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n");
        String[] input = new String[2];
        input[0] = readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        input[1] = readLine();

        return input;
    }

    public static List<String> splitParticipants(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();
    }
}
