package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<String> participantList = new ArrayList<>();

    public static boolean isValidName(String name) {

        return true;
    }

    public static void splitParticipantString(String rawString) {
        for (final String name : rawString.split(",")) {
            if (isValidName(name))
                participantList.add(name);
        }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String participants = Console.readLine();
            splitParticipantString(participants);
        } catch (Error e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다");
        } finally {
            Console.close();
        }
    }
}
