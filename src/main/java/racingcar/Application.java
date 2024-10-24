package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> participants = divideMember(getInput());

        int raceTimes = Integer.parseInt(getInput());

        List<Integer> countList = createParticipantCount(participants.size());

        raceManyTimes(raceTimes, countList, participants);

        List<Integer> maxCountList = getMaxIndexList(countList);

        printWinner(maxCountList, participants);
    }


    public static String getInput() {
        return Console.readLine();
    }

    public static List<String> divideMember(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            validateName(name);
        }
        return List.of(names);
    }

    private static void validateName(String name) {
        if (name.length() >= 5) {
            throw new IllegalArgumentException("자동차 이름은 5글자 이상으로 작성할수 없습니다.");
        }
    }


    public static List<Integer> createParticipantCount(int participantSize) {
        return new ArrayList<>() {{
            for (int participant = 0; participant < participantSize; participant++) {
                add(0);
            }
        }};
    }

    private static void raceManyTimes(int raceTimes, List<Integer> countList, List<String> participants) {
        for (int i = 0; i < raceTimes; i++) {
            raceOneTime(countList);
            printEachRaceResult(participants, countList);
            System.out.println();
        }
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
            System.out.print(participantName.get(i) + " : ");
            for (int i2 = 0; i2 < participantCount.get(i); i2++) {
                System.out.print("-");
            }
            System.out.println();
        }

    }

    public static List<Integer> getMaxIndexList(List<Integer> countList) {

        Optional<Integer> maxCount = countList.stream().max(Integer::compareTo);
        return maxCount.map(integer -> IntStream.range(0, countList.size())
                .filter(i -> countList.get(i).equals(integer))
                .boxed()
                .toList()).orElse(Collections.emptyList());
    }


    public static List<String> getNameOfIndex(List<Integer> maxCountIndexList, List<String> nameList) {
        return new ArrayList<>() {{
            for (Integer maxCountIndex : maxCountIndexList) {
                add(nameList.get(maxCountIndex));
            }
        }};
    }

    public static void printWinner(List<Integer> maxCountList, List<String> participants) {
        System.out.println("최종 우승자 : " + String.join(",", getNameOfIndex(maxCountList, participants)));
    }
}
