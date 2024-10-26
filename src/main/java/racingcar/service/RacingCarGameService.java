package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;

public class RacingCarGameService {

    public void moveCars(Cars cars){

        cars.getCars().forEach(car->{

            if(decideForward()){
                car.moveForward();
            }
        });

    }

    private boolean decideForward(){

        int randomNum = Randoms.pickNumberInRange(0,9);

        if(randomNum>=4){
            return true;
        }

        return false;
    }


}
