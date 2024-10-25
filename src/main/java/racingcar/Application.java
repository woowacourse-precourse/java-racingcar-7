package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();
        //playerNameList(inputName);
        System.out.println("시도할 횟수는 몇 회인가요?");
        int inputNum = intNumCheck(Console.readLine());
        Map<String,Integer> racingResult= racingByInputNum(playerNameList(inputName),inputNum);
        List<String> winnerList = winner(racingResult,firstUserValue(racingResult));
        System.out.println("최종 우승자 : "+String.join(",",winnerList));



    }

    public static Map<String,Integer> playerNameList(String inputName) {
        StringTokenizer tokenizer = new StringTokenizer(inputName, ",");
        Map<String, Integer> player = new HashMap<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if(token.length()>5){
                throw new IllegalArgumentException("5자 이하만 가능합니다. : "+token);
            }
            player.put(token, 0);
        }
        return player;

    }
    public static int randomNum(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        return randomNum;
    }
    public static int goAndStopNum(){
        if(randomNum() > 3) {
            return 1;
        } else return 0;
    }

    public static Map<String,Integer> racing(Map<String, Integer>playerNameList){
        for(String key :playerNameList.keySet()){
            playerNameList.replace(key,playerNameList.get(key)+goAndStopNum());
            System.out.println(key + " : "+"-".repeat(playerNameList.get(key)));

        }
        return playerNameList;
    }
    public static Map<String,Integer> racingByInputNum(Map<String, Integer>playerNameList, int inputNum){
        if (inputNum<0){
            throw new IllegalArgumentException("음수는 입력이 불가합니다 : "+inputNum);
        }
        System.out.println("\n실행 결과");
        for(int i = 0; inputNum > i; i++){
            racing(playerNameList);
            System.out.println("\n");
        }
        return playerNameList;
    }
    public static int firstUserValue(Map<String, Integer>playerNameList){
        int maxValue = Collections.max(playerNameList.values());
        return maxValue;
        }

    public static List<String> winner(Map<String, Integer>playerNameList, int maxValue){
        List<String> winner= new ArrayList<>();
        for(String key :playerNameList.keySet()){
            int value = playerNameList.get(key);
            if (value==maxValue){
                winner.add(key);
            }
        }
        return winner;
    }
    public static int intNumCheck (String stringNum){
        int inputNum;
        try {
            inputNum = Integer.parseInt(stringNum);

        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
        return inputNum;
    }
}
