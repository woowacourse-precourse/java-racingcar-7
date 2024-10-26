package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String playerInput=Console.readLine();
        HashMap<String,Integer> player=new HashMap<>();
        for (String s : playerInput.split(",")) {
            player.put(s,0);
        }

        String countInput=Console.readLine();
        int count;
        count=Integer.parseInt(countInput);

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
