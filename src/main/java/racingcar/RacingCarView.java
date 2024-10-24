package racingcar;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingCarView {
    public String getUserName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }
    public int getPlayTime(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(readLine());
    }
    public void currentState(HashMap<String, Integer> players){
        Iterator<String> keys = players.keySet().iterator();

        while (keys.hasNext()) {
            String key = keys.next();
            players.get(key);

            System.out.print(key + " : ");

            for(int i = 0; i < players.get(key); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void displayResult(LinkedList<String> winner){
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winner.size() - 1; i++) {
            System.out.print(winner.get(i) + ", ");
        }
        System.out.println(winner.get(winner.size() - 1));
    }
}
