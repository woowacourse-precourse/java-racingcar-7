package racingcar;

import camp.nextstep.edu.missionutils.Console;


import java.util.ArrayList;


public class Application {

    static String inputCar;
    static int playCount;

    static ParseInput parseInput;
    static CompetitionProgress competitionProgress;

    static void Input()  {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputCar= Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        playCount=Integer.parseInt(Console.readLine());

    }

    static void Output(CompetitionProgress competitionProgress) {

        ArrayList<Car> raceMember=competitionProgress.getRaceMember();

        System.out.println("실행 결과");
        for(int i=0;i<playCount;i++) {
            //System.out.println((i+1)+"번째 시행");
           for(Car car: raceMember) {
               PrintLog(car,i);
           }
        }
        System.out.println();

        ArrayList<Car> raceWinner =competitionProgress.getRaceWinner();
        int numberOfWinners=raceWinner.size();

        System.out.print("최종우승자 : ");
        for(int i=0;i<numberOfWinners;i++) {

            String winnerName=raceWinner.get(i).getName();

            if(i==numberOfWinners-1) {
                System.out.println(winnerName);
            } else {
                System.out.print(winnerName +", ");
            }
        }

    }

    static void PrintLog(Car car,int count) {

        ArrayList<Integer> raceLog=car.getMoveLog();
        String name=car.getName();
        int moveDistance=raceLog.get(count);

        System.out.print(name + ": ");
        for(int i=0;i<moveDistance;i++) {
            System.out.print("-");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input();

        //입력받은 입력값을 출전 자동차 별로 분리
        //입력의 예외값은 throw함
        try {
            parseInput=new ParseInput(inputCar);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }

        //자동차 대회 진행
        competitionProgress= new CompetitionProgress(parseInput,playCount);

        Output(competitionProgress);

    }
}
