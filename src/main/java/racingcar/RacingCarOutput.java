package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Vector;

public class RacingCarOutput {
    private int num;
    private Vector<Pair> v;

    RacingCarOutput(int num,Vector<Pair> v){
        this.num = num;
        this.v = v;
    }

    public void Output(){
        for(int i=0;i<num;i++){
            Print();
            System.out.println(" ");
        }
    }

    public void Print(){
        for(Pair s : v){
            if(Randoms.pickNumberInRange(0,9)>3){
                s.goForward();
            }
            System.out.print(s.getY()+" : ");
            for(int i=0;i<s.getX();i++){
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }
    public void Winner(){
        int max=0;
        Vector<String> Winners = new Vector<>();
        for(Pair s : v){
            if(max<s.getX()){
                max = s.getX();
            }
        }
        for(Pair s : v){
            if(max == s.getX()){
                Winners.add(s.getY());
            }
        }

        for(int i=0;i<Winners.size();i++){
            if(i==0){
                System.out.print(" "+Winners.get(i));
            }
            else{
                System.out.print(", "+Winners.get(i));
            }
        }
    }


}
