package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Game {
//    static ArrayList<String> winner = new ArrayList<>();
    public static void printCars(Car car){
        System.out.print(String.format("%s : ",car.carName));
        System.out.println("-".repeat(car.space));
    }

    public static String findWinner(ArrayList<Car> carList){
        int max = 0;
        ArrayList<String> winner = new ArrayList<>();
        ArrayList<Integer> carSpaceArr = new ArrayList<>();

        for (Car car:carList){
            if(car.space>=max){
                max = car.space;
            }
            carSpaceArr.add(car.space);
        }

        for (int i=0;i<carSpaceArr.size();i++){
            if(carSpaceArr.get(i)==max){
                winner.add(carList.get(i).carName);
            }
        }

        return String.join(",",winner);
    }
    public static void printWinner(String winner){
        System.out.println(String.format("최종 우승자 : %s",winner));
    }
}
