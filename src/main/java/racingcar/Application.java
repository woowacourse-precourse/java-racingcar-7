package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String racingGame = "pobi,woni,jun,gjd,adfi,adsf";
        
        String[] a = racingGame.split(",");
        int try_it = 5;
        for (int i = 0; i < try_it; i++) {
            int num = Randoms.pickNumberInRange(0, 9);
            System.out.println(num);
        }
        
        

    }
}
