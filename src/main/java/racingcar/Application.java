package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        try{
            List<String> winners = startRacing(inputRacers());
            printWinners(winners);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } finally{
            Console.close();
        }
    }


    public static List<String> inputRacers(){
        String racerNames = Console.readLine();
        List<String> racers = List.of(racerNames.split(","));
        if(isNameLengthOver5(racers)){
            throw new IllegalArgumentException();
        }
        return racers;
    }

    public static boolean isNameLengthOver5(List<String> racers) {
        for(String racer : racers) {
            if(racer.length() > 5) {
                return true;
            }
        }
        return false;
    }

    /* 도착했을 때, 어떻게 해야 효율적으로 도착했는지 알 수 있을까?
    *
    * 1. += 할 때마다, 현재 위치 저장.
    *
    **/

    public static List<String> startRacing(List<String> racers) {
        List<String> winners = null;
        int finishLine = Integer.parseInt(Console.readLine());
        int frontRacerLocation = 0;

        while(frontRacerLocation < finishLine){
            for(String racer : racers) {
                if( isSuccesMoving() ){
                    //출루
                }
            }
        }

        return winners;
    }

    public static void printWinners(List<String> winners){
        System.out.println("승자는 우리 모두야!");
    }

    public static boolean isSuccesMoving() {
        int randNum = Randoms.pickNumberInRange(0,9);
        if(randNum >= 4){
            return true;
        }

        return false;
    }



}


