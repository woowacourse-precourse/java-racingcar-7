package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
    public void race(String[] strings,int input) {
        String str="-";
        int[] sum = new int[10];
        int car= strings.length;
        for (int i=0;i<input;i++) {
            for (int j=0;j<car;j++){
                int number=Randoms.pickNumberInRange(0,9);
                if (number>3){
                    sum[j] +=number;
                }
                System.out.println(strings[j]+" : "+str.repeat(sum[j]));
            }
        }
        Winner winner=new Winner();
        winner.win(sum,strings);
    }
}
