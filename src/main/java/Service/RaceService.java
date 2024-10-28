package Service;

import VO.CarVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RaceService {
    public int runing(int value) {
        int randomPosition = pickNumberInRange(0, 9);
        if (randomPosition >= 4) {
            value++;
        }
        return value;
    }

    public List<CarVO> raceing(List<CarVO> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int position = cars.get(i).getPosition();
            int resultPosition = runing(position);
            cars.get(i).setPosition(resultPosition);
        }
        return cars;
    }

    public int getMaxPosition(List<CarVO> cars) {
        int position = 0;
        for (CarVO car : cars) {
            if (car.getPosition() > position) {
                position = car.getPosition();
            }
        }
        return position;
    }


    public List<String> winnerCars(List<CarVO> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);
        for (CarVO car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getCarName());
            }
        }
        Collections.sort(winners);
        return winners;
    }


}
