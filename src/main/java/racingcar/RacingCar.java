package racingcar;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RacingCar{
    private String carNames;
    private HashMap<String, Integer> record = new HashMap<>();
    private int numOfTrial;
    private InputReader inputReader;

    public RacingCar(InputReader inputReader){
        this.inputReader = inputReader;
    }

    public void race(){
        while(numOfTrial>0){
            for(String car : carNames) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                Integer numOfMovement = record.getOrDefault(car, 0);
                record.put(car, numOfMovement+1);
            }
            System.out.println("실행 결과");
            for(String car : carNames){
                System.out.printf("%s : ", car);
                for(int i=0; i<record.getOrDefault(car, 0); ++i){
                    System.out.printf("%c", '-');
                }
                System.out.println();
            }
            --numOfTrial;
        }
        Optional<Integer> longestMovement = record.values().stream().max(Integer::compareTo);
        ArrayList<String> winner = new ArrayList<>();
        for(String car : carNames){
            if(record.get(car).equals(longestMovement.get())){
                winner.add(car);
            }
        }
        System.out.printf("최종 우승자 : ");
        String result = String.join(",", winner);
        System.out.println(result);
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getNumOfTrial() {
        return numOfTrial;
    }
}
