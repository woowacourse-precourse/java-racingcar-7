package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private List<RacingCar> cars = new ArrayList<>();

    public String[] setCarName(String input) {
        return input.split(",");
    }

    public void setCar(String[] carNames) {
        for (String name : carNames) {
            cars.add(new RacingCar(name.trim()));
        }
    }

    public void startGame(){
        for(var car : cars) {
            int canGo = Randoms.pickNumberInRange(0, 9);
            if (canGo >= 4) {
                ++car.length;
            }
        }
    }

    public void printProgressOfGame(){
        for(var car : cars){
            System.out.println(car.carName + " : " + "-".repeat(car.length));
        }
        System.out.print('\n');
    }

    public void printResultOfGame(ArrayList<String> winners){
        int max = 0;
        
        for(var car : cars){
            if(car.length > max){
                winners.clear();
                winners.add(car.carName);
                max = car.length;
            }
            else if(car.length == max){
                winners.add(car.carName);
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application racingGame = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();  //사용자 입력
        String[] carNames = racingGame.setCarName(carNameInput);
        racingGame.setCar(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberOfGames = Console.readLine();
        int gameCount = Integer.parseInt(numberOfGames);

        System.out.println("\n실행 결과");
        for(int i = 0; i<gameCount; ++i){
            racingGame.startGame();
            racingGame.printProgressOfGame();
        }
        ArrayList<String> winners = new ArrayList<>();
        racingGame.printResultOfGame(winners);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}