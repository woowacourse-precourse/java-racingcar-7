package racingcar.model;

import racingcar.Util;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class CarList {

    private final ArrayList<Car> carList;

    public CarList(){
        this.carList = new ArrayList<>();
    }

    public void addCar(Car car){
       carList.add(car);
    }

    public void play(){
        goCars();
        ArrayList<String> roundResults = new ArrayList<>();
        for (Car car : carList) {
            roundResults.add(car.playResult());
        }
        //출력
    }

    public void winnerResult(){
        ArrayList<String> winners=new ArrayList<>();
        for(Car car:carList){
            if(car.isWinner(Util.getMax(getPostionList())) )
                winners.add(car.getName());
        }
        //출력
    }

    private void goCars(){
        carList.forEach(Car::go);
    }

    //모든 차의 position 리스트
    private ArrayList<Integer> getPostionList(){
        ArrayList<Integer> postionList = new ArrayList<>();
        carList.forEach(car -> postionList.add(car.getPositionNumber()));
        return postionList;
    }
}
