package racingcar.util;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class RaceUtils {

    public static String getWinners(final List<Car> carList) {
        List<String> winnerList = new ArrayList<>();

        PriorityQueue<Car> maxHeap = new PriorityQueue<>();
        maxHeap.addAll(carList);

        if (!maxHeap.isEmpty()) {
            Car car = maxHeap.poll();
            long maxMoves = car.getTotalMoves();
            winnerList.add(car.getName());

            while (!maxHeap.isEmpty() && maxHeap.peek().getTotalMoves() == maxMoves) {
                winnerList.add(maxHeap.poll().getName());
            }
        }

        return String.join(", ", winnerList);
    }
}
