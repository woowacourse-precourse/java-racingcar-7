package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsNameInput = Console.readLine();

        if(Character.isDigit(carsNameInput.charAt(0))) {
            throw new IllegalArgumentException();
        }else if(!carsNameInput.contains(",")){
            throw new IllegalArgumentException();
        }


        Map<String, Integer> carsInfo = new HashMap<>();
        for(String carName : carsNameInput.split(",")) {
            if(carName.trim().length() > 5) {
                throw new IllegalArgumentException();
            }
            carsInfo.put(carName, 0);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String chanceInput = Console.readLine();
        if(!Character.isDigit(chanceInput.charAt(0))) {
            throw new IllegalArgumentException();
        }

        System.out.println("실행 결과");
        for(int i = 0; i < Integer.parseInt(chanceInput); i++) {
            racing(carsInfo);
            printResult(carsInfo);
            System.out.println();
        }

        // 우승자 가려내기
        List<String> winners = new ArrayList<>();
        int max = 0;
        for(Map.Entry<String, Integer> entry : carsInfo.entrySet()) {
            if(entry.getValue() > max ) {
                max = entry.getValue();
                winners.clear();
                winners.add(entry.getKey());
            }else if(entry.getValue() == max) {
                winners.add(entry.getKey());
            }
        }

        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if(i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
    static void racing(Map<String, Integer> carsInfo) {
        // 자동차 별로 전진하는 것 구현
        for(String key : carsInfo.keySet()) {

            int random = Randoms.pickNumberInRange(0, 9);
            if(random >= 4){
                carsInfo.put(key, carsInfo.get(key) + 1);
            }
        }

    }
    static void printResult(Map<String, Integer> carsInfo) {
        // 출력하기
        for(Map.Entry<String, Integer> entry : carsInfo.entrySet()) {
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        }
    }
}
