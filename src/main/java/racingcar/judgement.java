package racingcar;

import java.util.ArrayList;
import java.util.List;

public class judgement {
    Car[] cars;

    public judgement(Car[] cars){
        this.cars = cars;
    }

    private void printResult(Car curCar){
        int curCarLocation = curCar.currentLocation();
        System.out.print(curCar.name() + " : ");
        for(int count = 0; count < curCarLocation; count++){
            System.out.print("-");
        }
        System.out.println();
    }

    public void updateResult(ArrayList<Integer> randomNumbers){
        for(int carIndex = 0; carIndex < cars.length; carIndex++){
            Car curCar = cars[carIndex];
            if(randomNumbers.get(carIndex) > 3){
                curCar.move();
            }
            printResult(curCar);
        }
        System.out.println();
    }

    private List<String> judgeWinner(){
        List<String> winnerList = new ArrayList<>();
        int maxLocationNum = cars[0].currentLocation();
        winnerList.add(cars[0].name());

        for(int i =1; i<cars.length; i++){
            Car curCar = cars[i];
            if (curCar.currentLocation() > maxLocationNum){
                maxLocationNum = curCar.currentLocation();
                winnerList.clear();
                winnerList.add(curCar.name());
                continue;
            }
            if(curCar.currentLocation() == maxLocationNum){
                winnerList.add(curCar.name());
            }
        }
        return winnerList;
    }

    public void printWinner(){
        System.out.print("최종 우승자 : " );
        List<String> winnerList = judgeWinner();
        for(int i=0; i < winnerList.size(); i++){
            System.out.print(winnerList.get(i));
            if(i != winnerList.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
