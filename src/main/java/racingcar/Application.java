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
            String winners = startRacing(inputRacers());
            printWinners(winners);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } finally{
            Console.close();
        }
    }

    public static List<String> inputRacers(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racerNames = Console.readLine();
        List<String> racers = List.of(racerNames.split(","));
        if(isNameLengthOver5(racers)){
            throw new IllegalArgumentException();
        }
        return racers;
    }

    public static boolean isNameLengthOver5(final List<String> racers) {
        for(String racer : racers) {
            if(racer.length() > 5) {
                return true;
            }
        }
        return false;
    }


    public static String startRacing(List<String> racers) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int finishLine = Integer.parseInt(Console.readLine());
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
            printCurRoundResult(racerInfo);
        }

        return announceWinner(racerInfo, finishLine);
    }

    public static List<String> raceReady(List<String> racers) {
        List<String> preparedRacer = new ArrayList<>();
        for(String racer : racers) {
            preparedRacer.add(racer + " : ");
        }
        return preparedRacer;
    }

    public static void printWinners(final String winners){
        System.out.println(winners);
    }

    public static boolean isSuccesMoving() {
        int randNum = Randoms.pickNumberInRange(0,9);
        return randNum >= 4;
    }

    public static void driveCar(final int index, List<String> racerInfo, List<Integer> racerLocations) {
        racerInfo.set(index, racerInfo.get(index) + "-");
        racerLocations.set(index, racerLocations.get(index) + 1);
    }

    public static String announceWinner(final List<String> racerInfo, final int finishLine) {
        String winners = "최종 우승자 :";
        int winnerCnt = 0;
        for(String info : racerInfo) {
            boolean racerResult = isWinner(info, finishLine);
            if(racerResult) { winnerCnt++; }
            if(racerResult && winnerCnt == 1){ //단독 우승자
                winners += " " + racerName(info);
            } else if(racerResult && winnerCnt >= 2){ // 우승자 여러명
                winners += ", " + racerName(info);
            }
        }
        return winners;
    }

    public static boolean isWinner(final String racerInfo, final int finishLine) {
        String driveDistance = subName(racerInfo);
        return driveDistance.length() == finishLine;
    }

    public static String racerName(final String racerInfo) {
        return racerInfo.substring(0, racerInfo.indexOf(" :"));
    }

    public static String subName(final String racerInfo) {
        return racerInfo.substring(racerInfo.indexOf(":") + 2);
    }

    public static List<Integer> initLocatoin(final int size) {
        List<Integer> racerLocations = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            racerLocations.add(0);
        }
        return racerLocations;
    }

    public static void printCurRoundResult(final List<String> racerInfo ){
        for(String Info : racerInfo) {
            System.out.println(Info);
        }
        System.out.println(); //다음 라운드 결과와 구분
    }
}


