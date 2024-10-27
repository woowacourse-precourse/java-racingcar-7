package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerText = Console.readLine();
        String[] player = playerText.split(",");

        // 이름 검증
        for(String p : player){
            if (p == null || p.length()>=6 || p.isEmpty()){
                throw new IllegalArgumentException("이름의 길이가 6자 이상이거나 이름이 없습니다");
            }
        }

        // Map으로 플레이어 : 게임 매칭
        HashMap<String, String >games = new HashMap<>();
        for (String p : player ){
            games.put(p, "");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundText = Console.readLine();

        // 들어오는 텍스트가 숫자인지 검증
        if (!roundText.matches("\\d+")) {
            throw new IllegalArgumentException("입력 값은 숫자만 포함해야 합니다.");
        }
        int round = Integer.parseInt(roundText);

        // round가 1 이상의 정수인지 검증
        if (round < 1) {
            throw new IllegalArgumentException("라운드는 1 이상의 정수여야 합니다.");
        }


        // 게임 실행
        for (int i=0;i<round;i++){
            for (String p : player){
                games = Game.play(p,games);
                System.out.println(p+" : "+games.get(p));
            }
            System.out.println(" ");
        }

        // 승자 구하기 알고리즘
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
            }
        }
        String winner = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winner);//결과 도출
    }
}