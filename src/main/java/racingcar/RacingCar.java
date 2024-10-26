package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private List<Car> carList = new ArrayList<>();
    private List<String> winnerList = new ArrayList<>();
    private int count = 0;

    public void setCarList(List<String> inputStringList) {
        for (String inputString : inputStringList) {
            throwErrorNameRule(inputString.trim());
            this.carList.add(new Car(inputString.trim()));
        }
    }

    private void throwErrorNameRule(String inputString){
        if (inputString.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public void repeatRacing(){
        Output.printExecuteResult();
        for (int i = 0; i<count; i++){
            playRacing();
            Output.printSpace();
        }
    }

    public void playRacing(){
        for (int index = 0; index < carList.size(); index++) {
            moveCar(index);
            Output.printCarPosition(carList.get(index));
        }
    }

    public void moveCar(int index){
        int number = Randoms.pickNumberInRange(0, 9);
        if (4<=number){
            carList.get(index).addPosition();
        }
    }

    public void run() {
        List<String> inputStringList = Input.getNameList();
        this.count = Input.inputNumber();
        setCarList(inputStringList);
        repeatRacing();
        getWinnerList();
        Output.printWinner(winnerList);
    }

    public void getWinnerList(){
        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = judgeWinner(car, maxPosition);
        }
    }

    public int judgeWinner(Car car, int maxPosition){
        if (car.getPosition() > maxPosition) {
            winnerList = new ArrayList<>();
            winnerList.add(car.getName());
            return car.getPosition();
        }else if(car.getPosition() == maxPosition){
            winnerList.add(car.getName());
            return maxPosition;
        }else{
            return maxPosition;
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
