package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> participants = divideMember(getInput());

        int raceTimes = Integer.parseInt(getInput());

        List<Integer> countList = createParticipantCount(participants.size());

        raceOneTime(countList);
        printEachRaceResult(participants, countList);
    }

    public static String getInput() {
        return Console.readLine();
    }

    public static List<String> divideMember(String input) {
        return List.of(input.split(","));
    }


    public static List<Integer> createParticipantCount(int participantSize) {
        return new ArrayList<>() {{
            for (int participant = 0; participant < participantSize; participant++) {
                add(0);
            }
        }};
    }

    public static void raceOneTime(List<Integer> countList) {
        for (int index = 0; index < countList.size(); index++) {
            int random = Randoms.pickNumberInRange(0, 9);
            if (random >= 4) {
                countList.set(index, countList.get(index) + 1);
            }
        }
    }

    public static void printEachRaceResult(List<String> participantName, List<Integer> participantCount) {
        for (int i = 0; i < participantName.size(); i++) {
            System.out.print(participantName.get(i) + ":");
            for (int i2 = 0; i2 < participantCount.get(i); i2++) {
                System.out.print("-");
            }
            System.out.println();
        }

    }
}
