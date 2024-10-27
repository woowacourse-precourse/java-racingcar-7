package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Application {

    static List<String> participantList = new ArrayList<>();
    static Map<String, Integer> participantMap = new HashMap<>();

    public static boolean isValidName(String name) {

        return true;
    }

    public static void splitParticipantString(String rawString) {
        for (final String name : rawString.split(",")) {
            if (isValidName(name))
                participantList.add(name);
        }

    }
    public static void addScore(String name){

    }

    public static void goRandomPlay(){
            for(final String name: participantList){
                int randomNumber= Randoms.pickNumberInRange(0,9);
                if(randomNumber>=4){
                    addScore(name);
                }
            }
    }

    //주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
    //  - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
    //- 자동차 경주 게임을 완료한 후 누가 우승했는지를 출력한다.
    //    - 우승자는 여러 명일 수 있다.
    //    - 우승자가 여러 명일 경우, 쉼표를 이용하여 구분한다.
    public static void playGame(String number) {
        int playNumber = Integer.parseInt(number);
        while (playNumber != 0) {
            goRandomPlay();
            playNumber--;
        }

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
