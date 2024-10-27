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

        //각 시행마다 이동한 결과 출력
        System.out.println("실행 결과");
        for(int i=0;i<playCount;i++) {
           for(Car car: raceMember) {
               PrintLog(car,i);
           }
           System.out.println();
        }


        ArrayList<Car> raceWinner =competitionProgress.getRaceWinner();
        int numberOfWinners=raceWinner.size();

        //최종 우승자 출력 2명 이상인 경우 모두 출력
        System.out.print("최종 우승자 : ");
        for(int i=0;i<numberOfWinners;i++) {

            String winnerName=raceWinner.get(i).getName();

            //마지막 우승 인원인 경우 , 붙이지 않고 출력 후 종료
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

        System.out.print(name + " : ");
        //이동한 거리만큼 - 출력
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

        //결과 출력
        Output(competitionProgress);

    }
}
