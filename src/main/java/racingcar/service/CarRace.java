package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarConstants;

import java.util.List;

public class CarRace {

    private static final CarConstants carconstants = new CarConstants();

    public List<Car> carRace(List<Car> carList){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine();
        int tryNum = validateTryNumConvert(tryNumString);

        System.out.println("실행 결과");
        for(int i = 0; i<tryNum; i++){
            carPositionRandom(carList);
            carPositionPrint(carList);
        }

        return carList;
    }

    private void carPositionPrint(List<Car> carList) {
        for(Car car : carList){
            System.out.println(car);
        }
        System.out.println();
    }

    private void carPositionRandom(List<Car> carList) {
        for(int i=0; i<carList.size(); i++){
            int random = Randoms.pickNumberInRange(0, 9);
            if(random >= carconstants.fowardRange){
                int position = carList.get(i).getPosition();
                carList.get(i).setPosition(++position);
            }
        }
    }

    private int validateTryNumConvert(String tryNumString) {
        int tryNum = Integer.parseInt(tryNumString);
        validateTryNumRange(tryNum);

        return tryNum;
    }

    private void validateTryNumRange(int tryNum) {
        if(tryNum > carconstants.tryNumRange)
            throw new IllegalArgumentException("error: 시도횟수 범위를 초과했습니다");
    }


}
