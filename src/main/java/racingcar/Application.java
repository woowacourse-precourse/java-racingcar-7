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

    }

    public static void goOrStop(HashMap<String,Integer> player){
        for (String s : player.keySet()) {
            if(Randoms.pickNumberInRange(0,9)>4){
                int steps=player.get(s);
                player.put(s,steps+1);
            }
        }
    }

    public static void printCar(HashMap<String,Integer> player){
        for(String s:player.keySet()){
            System.out.println(s+" : "+"-".repeat(player.get(s)));
        }
        System.out.println();
    }
}
