package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class InputHandler {

    private static final String NAME_DIAMETER = ",";

    public static List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return splitNames(readLine());
    }

    public static int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException();
        }

    }

    private static List<String> splitNames(String nameString) {
        String[] participants = nameString.split(NAME_DIAMETER);
        validateNames(participants);

        return Arrays.stream(participants).toList();
    }



    private static void validateNames(String[] participants) {
        for (String participant : participants) {
            if (participant.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}