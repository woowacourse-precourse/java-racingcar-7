package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static final int DISTANCE_POINT = 4;

    public static void main(String[] args) {
        String[] nameArray = getStrings();
        Map<String, Integer> nameMap = getNameMap(nameArray);
        int count = getCount();
        printRacing(count, nameMap);
        printWinner(nameMap);
    }

    private static void printWinner(Map<String, Integer> nameMap){
        System.out.println("최종 우승자 : " + String.join(", ", getWinner(nameMap)));
    }

    private static List<String> getWinner(Map<String, Integer> nameMap){
        int maxRecord = maxRecord(nameMap);
        List<String> winnerList = new ArrayList<>();
        for (String key : nameMap.keySet()) {
            if(nameMap.get(key) == maxRecord){
                winnerList.add(key);
            }
        }
        return winnerList;
    }

    private static int maxRecord(Map<String, Integer> nameMap){
        int maxNumber = 0;
        for (String key : nameMap.keySet()) {
            if(nameMap.get(key) > maxNumber){
                maxNumber = nameMap.get(key);
            }
        }
        return maxNumber;
    }

    private static void printRacing(int count, Map<String, Integer> nameMap){
        String bar = "-";
        System.out.println("실행 결과");
        for (int i = 0; i < count; i++) {
            addDistance(nameMap);
            for (String key : nameMap.keySet()) {
                System.out.println(key + " : " + bar.repeat(nameMap.get(key)));
            }
            System.out.println();
        }
    }

    private static void addDistance(Map<String, Integer> nameMap){
        nameMap.replaceAll((key, value) -> {
            int randomNumber = Randoms.pickNumberInRange(0,9);
            if(randomNumber >= 4){
                return value + 1;
            } else {
                return value;
            }
        });
    }

    private static int randomNumberAssignment(){
        return Randoms.pickNumberInRange(0,9);
    }

    private static boolean randomNumberCheck(int randomNumber){
        return randomNumber >= DISTANCE_POINT;
    }

    private static int getCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();
        int count = Integer.parseInt(inputCount);
        return count;
    }

    private static Map<String, Integer> getNameMap(String[] nameArray){
        Map<String, Integer> nameMap = new LinkedHashMap<>();
        for (String name : nameArray) {
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            nameMap.put(name,0);
        }
        return nameMap;
    }

    private static String[] getStrings(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputName = Console.readLine();
        String[] nameArray = inputName.split(",");
        return nameArray;
    }
}
