package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class RacingCarControllerTest {

    @Test
    public void setPlayersInfo(){

        String carName = "pobi,woni,jun";

        HashMap<String, Integer> players = new HashMap<String, Integer>();

        for (String n : carName.split(",")) {
            players.put(n, 0);
        }
        System.out.println(players.toString());
    }

    @Test
    public void startGame(){
        HashMap<String, Integer> players = new HashMap<String, Integer>();
        players.put("pobi", 0);
        int moveLength = 0;

        Set<String> carNames = players.keySet();
        Iterator<String> it = carNames.iterator();

        while(it.hasNext()){
            String carName = it.next();

            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                int currentMove = players.get(carName);
                players.replace(carName, ++currentMove);
                moveLength++;
            }
        }
        Assertions.assertEquals(players.get("pobi"), moveLength);
    }

    public void getResult(){
        LinkedList<String> winner = new LinkedList<>();
        HashMap<String, Integer> players = new HashMap<String, Integer>();
        players.put("pobi", 1);
        players.put("woni", 3);
        players.put("jun", 3);
        int maxValue = Collections.max(players.values());

        for (String key : players.keySet()) {
            if (players.get(key) == maxValue) {
                winner.add(key);
            }
        }
        Iterator<String> it = winner.iterator();
        Assertions.assertEquals("woni",it.next());
        Assertions.assertEquals("jun",it.next());
    }
}
