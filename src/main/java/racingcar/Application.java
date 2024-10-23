package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {
    static Map<String,String> map = new HashMap<>();
    static String[] input;
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine().split(",");
        validateInput(input);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int epoch = Integer.parseInt(Console.readLine());
        System.out.println("실행 결과");
        mapInit();
        for(int i=0;i<epoch;i++){
            for(int j=0;j<input.length;j++){
                String car = input[j];
                randomPlay(car);
            }
            for(int j=0;j<input.length;j++){
                System.out.println(input[j] + " : " + map.get(input[j]));
            }
            System.out.println();
        }
        ArrayList<String> winners = findWinner(map);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< winners.size()-1;i++){
            sb.append(winners.get(i)).append(", ");
        }
        sb.append(winners.getLast());
        System.out.println("최종 우승자 : " + sb);
    }

    private static ArrayList<String> findWinner(Map<String, String> map) {
        ArrayList<String> longestKeys = new ArrayList<>();
        int maxLength = 0;
        for(Map.Entry<String,String> entry : map.entrySet()) {
            int length = entry.getValue().length();
            if(length > maxLength) {
                maxLength = length;
                longestKeys.clear();
                longestKeys.add(entry.getKey());
            } else if (length == maxLength) {
                longestKeys.add(entry.getKey());
            }
        }
        return longestKeys;
    }

    private static void randomPlay(String s) {
        if(Randoms.pickNumberInRange(0,9) >= 4) {
            map.put(s,map.getOrDefault(s,"-") + "-");
        }
    }

    private static void validateInput(String[] input) {
        for(String s: input) {
            if(s.length() > 5) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
        }
    }

    private static void mapInit() {
        for(String s : input) {
            map.put(s,"");
        }
    }
}
