package racingcar;

import camp.nextstep.edu.missionutils.Console;

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
        

    }
}
