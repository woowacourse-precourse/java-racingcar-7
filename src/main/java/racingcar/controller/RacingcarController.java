package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.RacingInfo;
import racingcar.view.OutputView;

public class RacingcarController {

    private List<Integer> distance = new ArrayList<>();
    private int attempts;
    private int length;

    public RacingcarController() {
        this.attempts = RacingInfo.attempts;
        this.length = RacingInfo.cars.size();
        initializeDistance();
    }

    private void initializeDistance() {
        for (int i = 0; i < length; i++) {
            distance.add(0);
        }
    }

    public void race() {
        OutputView.resultOutput();
        for (int i = 0; i < attempts; i++) {
            moveCars(length, distance);  // length와 distance를 매개변수로 전달
            OutputView.racingProgressOutput(distance);
        }
        determineWinners(length, distance);  // length와 distance를 매개변수로 전달
    }

    public static void moveCars(int length, List<Integer> distance) {
        List<Integer> moveDistances = randomMove(length);
        for (int i = 0; i < length; i++) {
            distance.set(i, distance.get(i) + moveDistances.get(i));
        }
    }

    public static List<Integer> randomMove(int length) {
        List<Integer> movements = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                movements.add(1);
            } else {
                movements.add(0);
            }
        }
        return movements;
    }

    public static void determineWinners(int length, List<Integer> distance) {
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (int dist : distance) {
            if (dist > maxDistance) {
                maxDistance = dist;
            }
        }

        for (int i = 0; i < length; i++) {
            if (distance.get(i) == maxDistance) {
                winners.add(RacingInfo.cars.get(i));
            }
        }

        OutputView.winnerOutput(winners);
    }

}