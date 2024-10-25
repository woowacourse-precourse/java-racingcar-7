package racingcar;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Assertions;

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

    public static List<String> startRacing(List<String> racers) {
        List<String> winners = null;
        int FinishLine = Integer.parseInt(Console.readLine());


        return winners;
    }

    public static void printWinners(List<String> winners){
        System.out.println("승자는 우리 모두야!");
    }



}


