package gameManager;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.stream;


public class Display {

    private String names;
    private String[] gamer;
    private int round;
    final static String REQUEST_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final String REQUEST_ROUND = "시도할 횟수는 몇 회인가요?";
    final String RESULT_MSG = "실행 결과";
    final String WINNER_MSG = "최종 우승자 : ";

    public void setNames() {
        names = Console.readLine();
    }

    public String getNames() {
        return names;
    }

    //input 스트링을 ','로 나눠 배열에 담아 반환
    public void setGamerNameArr(String names) {
        /*isNullOrEmpty(names);
        validateGamerNumber(names);
        gamer = names.split("," ,-1);
        validateNameLength(gamer);*/
        gamer = Validation.nameCheck(names);
    }

    public String[] getGamerNameArr() {
        return gamer;
    }


    public void setRound() {
        String round = Console.readLine();
        setRound(round);
    }

    public void setRound(String input) {
        //isNullOrEmpty(round);
        /*int intRound = parseToInt(round);
        checkNegative(intRound);
        this.round = intRound;*/
        this.round = Validation.roundCheck(input);
    }

    public int getRound() {
        return round;
    }


    public void outputScores(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String dashes = "-".repeat(entry.getValue());
            System.out.println(entry.getKey() + " : " + dashes);
        }
        System.out.println();
    }

    public String getWinnersList(Set<String> winners) {
        return String.join(", ", winners);
    }

    public static void requestName() {
        System.out.println(REQUEST_NAMES);
    }

    public void requestRound() {
        System.out.println(REQUEST_ROUND);
    }

    public void resultMsg() {
        System.out.println(RESULT_MSG);
    }

    public void winnerMsg(Set<String> winners) {
        System.out.println(WINNER_MSG + getWinnersList(winners));
    }
}
