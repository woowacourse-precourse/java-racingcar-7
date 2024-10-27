package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        RaceDto data = new RaceDto();
        getInput(data);
        System.out.println(data);

        DataTrans(data);
        StartRace(data);

        CheckResult(data);

        Winner(data);
    }

    public static void getInput(RaceDto data){
        System.out.println("경주할 자동차 이름을 \",\"로 구분하여 입력해주세요 ");
        data.carName = Console.readLine();
        System.out.println("시도할 횟수를 입력해주세요");
        data.num = Integer.parseInt(Console.readLine());
    }

    public static void DataTrans(RaceDto data){
        data.racers = data.carName.split(",");
        for(int i = 0; i < data.racers.length; i++){
            data.racers[i] = data.racers[i].trim();
            if(data.racers[i].length() > 5){
                throw new IllegalArgumentException();
            }
        }
        data.forwardNum = new int[data.racers.length];
    }

    public static void StartRace(RaceDto data){

        for(int i = 0; i < data.racers.length; i++){
            for(int j = 0; j < data.num; j++){
                if(Randoms.pickNumberInRange(0,9) > 5){
                    data.forwardNum[i]++;
                }
            }
        }
    }

    public static void CheckResult(RaceDto data){
        for(int i = 0; i < data.racers.length; i++){
            System.out.println(data.racers[i] + " : " + "-".repeat(data.forwardNum[i]));
        }
    }

    public  static void Winner(RaceDto data){

        int max = 0;
        int[] winners = new int [data.racers.length];
        int count = 0;

        for (int i = 0; i < data.racers.length; i++) {
            if (data.forwardNum[i] > max) {
                max = data.forwardNum[i];
                count = 0;
                winners[count] = i;
                count++;
            } else if (data.forwardNum[i] == max) {
                winners[count] = i;
                count++;
            }
        }
        System.out.print("최종 우승자: ");
        for (int i = 0; i < count; i++) {
            System.out.print(data.racers[winners[i]]);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
    }
}

class RaceDto{
    String carName;
    int num;
    String[] racers;
    int[] forwardNum;
}
