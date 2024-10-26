package InputOutput;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Output {
    public static void firstPrintMessage(){
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    }
    public static void roundPrint(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    private static void updateRaceAndPrintResult(Map<String, String> race){
        for (String key : race.keySet()) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                race.put(key, race.get(key) + "-");
            }
            System.out.println(key + " : " + race.get(key));
        }
        System.out.println("");
    }
    public static void raceResult(int count, Map<String, String> race){
        System.out.println("");
        System.out.println("실행 결과");
        for(int i = 0; i < count; i++){
            updateRaceAndPrintResult(race);
        }
        int max = 0;
        List<String> maxKeys = new ArrayList<>();

        for (String key : race.keySet()) {
            int currentLength = race.get(key).length();
            if (currentLength > max) {
                max = currentLength;
                maxKeys.clear();
                maxKeys.add(key);
            }
            if (currentLength == max) {
                maxKeys.add(key);
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", maxKeys));
    }

}
