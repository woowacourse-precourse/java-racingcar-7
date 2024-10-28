package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomMove {
    Players players=new Players();
    int randomNum=0;

    public void randomMove(int n){
        for(int i=0;i<n;i++){
            int a=Randoms.pickNumberInRange(0, 9);
        }
    }

    public void printPlayers(int index){
        String countLine="-".repeat(players.getCount().get(index));
        String playerName = players.getNames().get(index);

        System.out.printf("%s : %s\n", countLine, playerName);
    }
}
