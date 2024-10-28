package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.PriorityQueue;

public class ResultWinner {
    public ResultWinner(){};
    public void showWinner(List<Car>carList){
        PriorityQueue<Car>carPriorityQueue = new PriorityQueue<>((car1, car2)->car2.getPosition() - car1.getPosition());
        // 모든 자동차를 큐에 추가
        for (Car car : carList) {
            carPriorityQueue.add(car);
        }

        // 가장 높은 위치 확인
        int maxPosition = carPriorityQueue.peek().getPosition();

        // 우승자를 저장할 리스트
        StringBuilder winners = new StringBuilder("최종 우승자 : ");

        // 가장 높은 위치에 있는 자동차들을 모두 출력
        while (!carPriorityQueue.isEmpty() && carPriorityQueue.peek().getPosition() == maxPosition) {
            Car winner = carPriorityQueue.poll();
            winners.append(winner.getName()).append(", ");
        }

        // 마지막 쉼표와 공백 제거
        if (winners.length() > 0) {
            winners.setLength(winners.length() - 2);  // 마지막 쉼표 제거
        }

        System.out.println(winners);
    }
}
