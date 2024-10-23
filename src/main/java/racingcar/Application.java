package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String players = Console.readLine();
        // Todo. players 검증 (이름은 5자 이하)

        String[] player = players.split(",");
        HashMap<String, String >games = new HashMap<>();
        for (String p : player ){
            games.put(p, "");
        }
        System.out.println(games);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int round = Integer.parseInt(Console.readLine());

        // Todo. round 검증

        for (int i=0;i<round;i++){
            for (String p : player){
                if (Dice.roll()){
                    String rail = games.get(p)+"-";
                    games.put(p,rail);
                }
                System.out.println(p+" : "+games.get(p));
            }
            System.out.println(" ");
        }

        int far =0;
        List<String> winners = new ArrayList<>();

        for (HashMap.Entry<String, String> entry : games.entrySet()){
            int value = entry.getValue().length();
            if(value >far){
                far = value;
                winners.clear();
                winners.add(entry.getKey());

            } else if (value == far){
                winners.add(entry.getKey());
            }else {
                continue;
            }
        }
        String winner ="";
        for (String w : winners){
            winner= winner + w + " ";
        }
        System.out.println("최종 우승자 : "+winner); //결과 도출
    }
}
