package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

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
        return List.of(input.split(","));
    }

    public static void checkValid(List<String> participants, String executionCount) {
        for (String participant : participants) {
            if (participant.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }

        if (!executionCount.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자 입력 형식이 잘못되었습니다.");
        }
    }

    public static void simulate() {
        String[] input = input();
        List<String> participants = splitParticipants(input[0]);
        checkValid(participants, input[1]);

        int executionCount = Integer.parseInt(input[1]);
        int[] scores = new int[participants.size()];

        for (int i = 0; i < executionCount; i++) {
            moveParticipants(scores);
            printScores(participants, scores);
        }

        System.out.println("최종 우승자 : " + getWinner(scores, participants));
    }

    public static void moveParticipants(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                scores[i] += 1;
            }
        }
    }

    private static void printScores(List<String> participants, int[] scores) {
        for (int i = 0; i < participants.size(); i++) {
            System.out.println(participants.get(i) + " : " + "-".repeat(scores[i]));
        }
    }


    private static String getWinner(int[] scores, List<String> participants) {
        List<Integer> winnerIndex = new ArrayList<>();
        int maxScore = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > maxScore) {
                winnerIndex.clear();
                maxScore = scores[i];
            }
            if (scores[i] == maxScore) {
                winnerIndex.add(i);
            }
        }

        StringBuilder winner = new StringBuilder();

        for (int i = 0; i < winnerIndex.size(); i++) {
            int participantsIdx = winnerIndex.get(i);
            winner.append(participants.get(participantsIdx));

            if (i == winnerIndex.size() - 1) continue;
            winner.append(", ");
        }

        return winner.toString();
    }


}
