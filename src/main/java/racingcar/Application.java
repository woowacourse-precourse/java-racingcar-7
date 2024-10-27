package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Application {

    static List<String> participantList = new ArrayList<>();
    static Map<String, Integer> participantScore = new HashMap<>();

    static List<String> winners = new ArrayList<>();

    public static boolean isValidName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5글자 이하이어야 합니다.");
        }
        if (participantList.contains(name)) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
        return true;
    }

    public static void splitParticipantString(String rawString) {
        for (final String name : rawString.split(",")) {
            if (isValidName(name))
                participantList.add(name);
        }

    }

    public static void addScore(String name) {
        int number = participantScore.get(name);
        participantScore.put(name, number + 1);
    }

    public static void goRandomPlay() {
        for (final String name : participantList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                addScore(name);
            }
        }
    }

    public static void displayStatus() {
        for (final String name : participantScore.keySet()) {
            System.out.print(name + " : ");
            int score = participantScore.get(name);
            while (score != 0) {
                System.out.print('-');
                score--;
            }
            System.out.println();
        }
    }

    public static void initScore() {
        for (final String name : participantList) {
            participantScore.put(name, 0);
        }
    }

    public static int getBestScore() {
        int maxScore = 0;
        for (final int score : participantScore.values()) {
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public static void calculateFinal() {
        int maxScore = getBestScore();
        for (final String name : participantList) {
            if (maxScore == participantScore.get(name)) {
                winners.add(name);
            }
        }
    }

    public static void displayWinners() {
        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }

    public static void playGame(String number) {
        int playNumber = Integer.parseInt(number);
        initScore();
        while (playNumber != 0) {
            goRandomPlay();
            displayStatus();
            System.out.println();
            playNumber--;
        }
        calculateFinal();
        displayWinners();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String participants = Console.readLine();
            splitParticipantString(participants);
            System.out.println("시도할 횟수는 몇 회인가요?");
            String playNumber = Console.readLine();
            playGame(playNumber);
        } catch (Error e) {
            throw new IllegalArgumentException("입력이 잘못되었습니다");
        } finally {
            Console.close();
        }
    }
}
