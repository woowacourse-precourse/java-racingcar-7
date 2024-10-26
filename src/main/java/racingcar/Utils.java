package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Utils {
    public List<Car> setParticipants(String[] splited) {
        List<Car> cars = new ArrayList<>();
        for (String carName : splited) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public boolean canMove() {
        int n = Randoms.pickNumberInRange(0, 9);
        if (n >= 4) {
            return true;
        }
        return false;
    }

    public List<Car> countWinners(List<Car> participants) {
        participants.sort(new CarMoveCntComparator());
        List<Car> winners = new ArrayList<>();
        winners.add(participants.getFirst());
        int winningMoves = participants.getFirst().getMovedCnt();
        for (int i = 1; i < participants.size(); i++) {
            if ((participants.get(i).getMovedCnt() == winningMoves)) {
                winners.add(participants.get(i));
                continue;
            }
            break;
        }
        return winners;
    }

    static class CarMoveCntComparator implements Comparator<Car> {
        @Override
        public int compare(Car c1, Car c2) {
            return c2.getMovedCnt() - c1.getMovedCnt();
        }
    }
}
