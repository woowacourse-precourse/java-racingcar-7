package racingcar;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        RaceGame raceGame = new RaceGame();

        String userInputForNames;
        String userInputForRound;
        RacingCar[] carList;
        String[] winners;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        try{
            userInputForNames = raceGame.getUserInput();
            raceGame.getNamesList(userInputForNames);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e){
            System.out.print(e.getMessage());
            throw new IllegalArgumentException(e);
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            userInputForRound = raceGame.getUserInput();
            raceGame.getTotalRounds(userInputForRound);
        } catch (Exception e) {
            System.out.print(e.getMessage());
            throw new IllegalArgumentException(e);
        }

        try{
            carList = raceGame.registerCar(raceGame.carNamesList, raceGame.totalCars);
        } catch (Exception e){
            throw new IllegalArgumentException(e);
        }

        System.out.println("\n실행 결과");

        for (int i = 0; i < raceGame.totalRounds; i++){
            raceGame.playOneRound(carList);
            raceGame.printRoundResult(carList);
            System.out.println();
        }

        winners = raceGame.findWinningCars(carList);
        String result = "최종 우승자 : "+ String.join(", ",winners);
        System.out.println(result);

    }
}
