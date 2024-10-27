package racingcar;

import java.util.*;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    public static final HashMap<String, Integer> carList = new HashMap<>();
    public static final String moveString = "-";
    public static List<String> Winner = new ArrayList<>();
    //public static StringBuilder resultString = new StringBuilder("최종 우승자 : ");

    public static void run(final String carNameString, final String roundString){
        if (carNameString==null || carNameString.isBlank()){
            throw new IllegalArgumentException();
        }

        if (roundString==null || roundString.isBlank()){
            throw new IllegalArgumentException();
        }
        int round = Integer.parseInt(roundString);

        for(final String carNameSplit: carNameString.split(",")){
            if (carNameSplit.length()>5){
                throw new IllegalArgumentException();
            }
            carList.put(carNameSplit, 0);
        }

        System.out.println("실행결과");
        for(int i=0; i<round; i++) {
            for (String carName : carList.keySet()) {
                int randomMove = Randoms.pickNumberInRange(0, 9);
                if (randomMove >= 4) {
                    carList.put(carName, carList.get(carName) + 1);
                }
                System.out.println(carName + " : " + moveString.repeat(carList.get(carName)));
            }
            System.out.println();
        }
    }
}
