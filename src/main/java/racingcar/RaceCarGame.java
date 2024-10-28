package racingcar;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.*;
public class RaceCarGame {
    private ArrayList<RaceCar> cars;
    private int cnt;
    private ArrayList<Integer> randomsList;
    RaceCarGame(ArrayList<RaceCar> cars, int cnt){
        this.cars = cars;
        this.cnt = cnt;
        this.randomsList = (ArrayList<Integer>) IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
    }

    public void race(){
        for(int i = 0; i < this.cnt; i++){
            forwardUpdate();
        }
    }

    private void forwardUpdate(){
        for(RaceCar raceCar : this.cars){
            raceCar.updateForward(Randoms.pickNumberInList(this.randomsList));

            System.out.println(raceCar.getName() + " 점수 : " + raceCar.getForward());
        }
        System.out.println();
    }
}
