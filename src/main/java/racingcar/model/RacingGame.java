package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingGame {
    public static String race(ArrayList<String> participants, int num){
        int[] score = new int[participants.size()];
        String winner="";
        Arrays.fill(score, 0);

        while(true) {
            for (int i = 0; i < participants.size(); i++) {
                int randomNum = Randoms.pickNumberInRange(0,9);
                if(randomNum >=4 && randomNum <=9){
                    score[i] += 1;
                }
            }
            boolean flag = false;

            for (int i = 0; i < participants.size(); i++) {
                System.out.print(participants.get(i) + " : ");
                for (int j = 0; j < score[i]; j++) {
                    System.out.print("-");
                }
                if (score[i] == num) {
                    flag = true;
                    winner = winner + (participants.get(i) + ", ");
                }
                System.out.println();
            }
            System.out.println();
            if(flag) break;
        }
        return winner;
    }
}
