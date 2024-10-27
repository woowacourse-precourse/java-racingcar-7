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
    }
}
