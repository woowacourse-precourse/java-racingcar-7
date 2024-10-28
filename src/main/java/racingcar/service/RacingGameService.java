package racingcar.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.common.Game;
import racingcar.util.RandomUtil;

public class RacingGameService {

    private final RandomUtil randomUtil;

    public RacingGameService(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    public List<String> play(Game game) {
        int count = game.getCount();
        String[] cars = game.getCars();
        int[] moveCount = new int[cars.length];

        for (int i = 0; i < count; i++) {
            move(moveCount);
            displayRace(cars,moveCount);
        }

        return determineWinners(cars,moveCount);
    }

    private void move(int[] moves) {
        for (int i = 0; i < moves.length; i++) {
            if(randomUtil.goAndStop()){
                moves[i]++;
            }
        }
    }

    private void displayRace(String[] cars, int[] result) {
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " : " + "-".repeat(Math.max(0, result[i])));
        }
        System.out.println();
    }

    private List<String> determineWinners(String[] cars, int[] moveCount) {
        int maxDistance = Arrays.stream(moveCount).max().orElseThrow(NullPointerException::new);
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.length; i++) {
            if(moveCount[i] == maxDistance){
                winners.add(cars[i]);
            }
        }
        return winners;
    }
}
