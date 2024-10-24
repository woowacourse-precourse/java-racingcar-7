package racingcar.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Race { // 경주를 관리하는 클래스
    private List<Car> winner = new ArrayList<>();

    private PriorityQueue<Car> maxheap = new PriorityQueue<>(
            Comparator.comparingInt(Car::getPosition).reversed()
    );

    public PriorityQueue<Car> getMaxheap() {
        return maxheap;
    }

    public List<Car> getWinner() {
        return winner;
    }
}
