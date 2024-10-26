package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        run();
    }

    public static void run(){
        try{
            String winners = startRacing(inputRacers());
            printWinners(winners);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } finally{
            Console.close();
        }
    }


    public static List<String> inputRacers(){
        String racerNames = "ab,cd,ef"; //Console.readLine();
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

    public static String startRacing(List<String> racers) {
        int finishLine = 5; //Integer.parseInt(Console.readLine());
        int frontRacerLocation = 0;

        List<String> racerInfo = raceReady(racers);
        List<Integer> racerLocations = initLocatoin(racers.size());

        while(frontRacerLocation < finishLine){
            for(int i=0; i<racers.size(); i++) {
                if( isSuccesMoving() ){
                    driveCar(i, racerInfo, racerLocations);
                    int curLocation = racerLocations.get(i);
                    if(curLocation > frontRacerLocation) { frontRacerLocation++; }
                }
            }
        }

        String winners = announceWinner(racerInfo, finishLine);
        return winners;
    }

    public static List<String> raceReady(List<String> racers) {
        List<String> preparedRacer = new ArrayList<>();
        for(String racer : racers) {
            preparedRacer.add(racer + " : ");
        }
        return preparedRacer;
    }

    public static void printWinners(String winners){
        System.out.println(winners);
    }

    public static boolean isSuccesMoving() {
        int randNum = Randoms.pickNumberInRange(0,9);
        if(randNum >= 4){
            return true;
        }

        return false;
    }

    public static void driveCar(int index, List<String> racerInfo, List<Integer> racerLocations) {
        racerInfo.set(index, racerInfo.get(index) + "-");
        racerLocations.set(index, racerLocations.get(index) + 1);
    }

    public static String announceWinner(List<String> racerInfo, int finishLine) {
        String winners = "최종 우승자 :";
        for(String info : racerInfo) {
            boolean racerResult = isWinner(info, finishLine);
            if(racerResult){
                winners += " " + racerName(info);
            }
        }
        return winners;
    }

    public static boolean isWinner(String racerInfo, int finishLine) {
        String driveDistance = subName(racerInfo);
        if(driveDistance.length() == finishLine){
            return true;
        }
        return false;
    }

    public static String racerName(String racerInfo) {
        return racerInfo.substring(0, racerInfo.indexOf(" :"));
    }

    public static String subName(String racerInfo) {
        return racerInfo.substring(racerInfo.indexOf(":") + 2);
    }

    public static List<Integer> initLocatoin(int size) {
        List<Integer> racerLocations = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            racerLocations.add(0);
        }
        return racerLocations;
    }
}


