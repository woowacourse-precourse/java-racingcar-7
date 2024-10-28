package racingcar.Service;

import racingcar.Car;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.StreamSupport;

public class CarService {
    public Car[] convertToCar(String[] carNames){
        int carLen = carNames.length;
        Car[] cars = new Car[carLen];
        for(int i = 0; i < carLen; i++){
            Car car = new Car(carNames[i],0);
            cars[i] = car;
        }
        return cars;
    }

    public void startRace(Car[] cars){
        for(Car car: cars){
            int rnd = Randoms.pickNumberInRange(0,9);
            if(rnd>=4) car.goFront();
        }
    }

    public int[] maxWinCnt(Car[] cars){
        int mx =0,mxCnt=0;
        int[] mxInfo = new int[2];
        for(int i=0;i<cars.length;i++){
            if(mx == cars[i].getCarLocation()) mxCnt++;
            else if(mx<cars[i].getCarLocation()){
                mx=cars[i].getCarLocation();
                mxCnt=1;
            }
        }
        mxInfo[0] = mx;
        mxInfo[1] = mxCnt;
        return mxInfo;
    }

    public String[] calWinner(Car[] cars){
        int[] mxInfo = maxWinCnt(cars);
        String[] winnerNames = new String[mxInfo[1]];
        int cnt=0;
        for(Car car : cars){
            if(car.getCarLocation() == mxInfo[0]){
                winnerNames[cnt++] = car.getCarName();
            }
        }

        for(String s: winnerNames) System.out.println(s);

        return winnerNames;
    }


}
