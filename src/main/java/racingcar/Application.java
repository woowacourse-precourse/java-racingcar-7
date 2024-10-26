package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static final int DISTANCE_POINT = 4;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputName = Console.readLine();
        String[] nameArray = inputName.split(",");
        Map<String, Integer> nameMap = new LinkedHashMap<>();
        for (String name : nameArray) {
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            nameMap.put(name,0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        int count = Integer.parseInt(inputCount);

        String bar = "-";
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            nameMap.replaceAll((key, value) -> {
                int randomNumber = Randoms.pickNumberInRange(0,9);
                if(randomNumber >= 4){
                    return value + 1;
                } else {
                    return value;
                }
            });
            for (String key : nameMap.keySet()) {
                System.out.println(key + " : " + bar.repeat(nameMap.get(key)));
            }
            System.out.println();
        }
        int maxRecord = 0;
        for (String key : nameMap.keySet()) {
            if(nameMap.get(key) > maxRecord){
                maxRecord = nameMap.get(key);
            }
        }
        List<String> winnerList = new ArrayList<>();
        for (String key : nameMap.keySet()) {
            if(nameMap.get(key) == maxRecord){
                winnerList.add(key);
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }
}
