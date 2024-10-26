package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerInput=Console.readLine();
        if(playerInput==null || playerInput.isEmpty()){
            throw new IllegalArgumentException();
        }

        HashMap<String,Integer> player=new HashMap<>();
        for (String s : playerInput.split(",")) {
            if(s.isEmpty()|| s.length()>5 || !s.matches("^[A-z]+$")){
                throw new IllegalArgumentException();
            }
            player.put(s,0);
        }

        //플레이어 입력 테스트용
//        StringBuilder playerInputTest=new StringBuilder();
//        playerInputTest.append("players: ");
//        int playerCount=0;
//        for(String s: player.keySet()){
//            if(playerCount<player.size()-1) {
//                playerInputTest.append(s).append(", ");
//            }else {
//                playerInputTest.append(s);
//            }
//        }
//        System.out.println(playerInputTest);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String countInput=Console.readLine();
        int count;
        try {
            count = Integer.parseInt(countInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
        if(count<=0){
            throw new IllegalArgumentException();
        }

        //횟수 입력 테스트용
//        System.out.println("count: "+count);

        for(int i=0;i<count;i++){
            goOrStop(player);
            printCar(player);
        }

        int max=0;
        for(String s:player.keySet()){
            int playerSteps=player.get(s);
            if(playerSteps>max){
                max=playerSteps;
            }
        }

        ArrayList<String> winners=new ArrayList<>();
        for(String s:player.keySet()){
            if(player.get(s)==max){
                winners.add(s);
            }
        }

        StringBuilder builder=new StringBuilder();
        builder.append("최종 우승자 : ");
        for(int i=0;i<winners.size();i++){
            if(i<winners.size()-1){
                builder.append(winners.get(i)).append(", ");
            }else{
                builder.append(winners.get(i));
            }
        }
        System.out.println(builder);

    }

    public static void goOrStop(HashMap<String,Integer> player){
        for (String s : player.keySet()) {
            if(Randoms.pickNumberInRange(0,9)>=4){
                int steps=player.get(s);
                player.put(s,steps+1);
            }
        }
    }

    public static void printCar(HashMap<String,Integer> player){
        for(String s:player.keySet()){
            String step="-".repeat(player.get(s));
            System.out.println(s+" : "+step);
        }
        System.out.println();
    }
}
