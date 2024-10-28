package racingcar;

import java.util.List;

public class View {
    public static void outputRace(Racers racers) {
        racers.forEach(racer -> System.out.println(racer));
    }


    public static void outputWinners(List<String> winners){
        System.out.println("최종 우승자 : " + String.join(",",winners));
    }
}
