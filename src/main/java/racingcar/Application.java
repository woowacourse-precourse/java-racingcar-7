package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Application {

    public static HashMap<String, String> getUserInfo() {
        String input = Console.readLine();
        String[] StrArr_Name = input.split(",");
        int times = Integer.parseInt(Console.readLine());
        HashMap<String, String> scoreMap = new HashMap<>();
        for (String name:StrArr_Name) {
            if (name.length() > 5){
                throw new IllegalArgumentException();
            }
            scoreMap.put(name, "");
        }
        for (int i = 0; i < times; i++) {
            for (String name:scoreMap.keySet()) {
                if (Randoms.pickNumberInRange(0,9) >= 4){
                    String step = scoreMap.get(name) + "-";
                    scoreMap.put(name, step);
                }
                System.out.println(name + " : " + scoreMap.get(name));
            }

        }
        return scoreMap;
    }
    public static ArrayList findWinner(HashMap<String, String> scoreMap) {
        HashMap<String, Integer> WinnerArray = new HashMap<>();
        for (String name:scoreMap.keySet()){
            WinnerArray.put(name, scoreMap.get(name).length());
        }
        int winnerScore = Collections.max(WinnerArray.values());
        ArrayList<String> ArrWinner = new ArrayList<>(scoreMap.size());
        for (String name:WinnerArray.keySet()) {
            if (WinnerArray.get(name).equals(winnerScore)) {
                ArrWinner.add(name);
            }
        }
        return ArrWinner;
        }


    public static void main(String[] args){
        HashMap<String, String> scoreMap = getUserInfo();
        ArrayList arrayList = findWinner(scoreMap);
        System.out.print("최종 우승자 : ");
        for(Object s:arrayList){
            System.out.print(s);
            if (s != arrayList.get(arrayList.size()-1)){
                System.out.print(", ");
            }
            else{
                System.out.print("");
            }
            ;
        }
    }
}
