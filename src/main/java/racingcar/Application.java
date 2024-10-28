package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private List<RacingCar> cars = new ArrayList<>();

    public String[] splitCarName(String input) {
        return input.split(",");
    }

    public Set<String> setCarName(String[] carNames) {
        Set<String> carNamesSet = new HashSet<>();

        for (String name : carNames) {
            carNamesSet.add(name.trim()); //이름 양쪽 공백 제거 후 추가
        }
        if(carNamesSet.isEmpty()) throw new IllegalArgumentException();
        return carNamesSet;
    }

    public void setCar(Set<String> carNamesSet) {
        for (String name : carNamesSet) {
            cars.add(new RacingCar(name.trim()));
        }
    }

    public void startGame(){
        for(var car : cars) {
            int canGo = Randoms.pickNumberInRange(0, 9);
            if (canGo >= 4) {
                ++car.numberOfForward;
            }
        }
    }

    public void printProgressOfGame(){
        for(var car : cars){
            System.out.println(car.carName + " : " + "-".repeat(car.numberOfForward));
        }
        System.out.print('\n');
    }

    public void printResultOfGame(ArrayList<String> winners){
        int max = 0;
        
        for(var car : cars){
            if(car.numberOfForward > max){
                winners.clear();
                winners.add(car.carName);
                max = car.numberOfForward;
            }
            else if(car.numberOfForward == max){
                winners.add(car.carName);
            }
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application racingGame = new Application();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameInput = Console.readLine();
        String[] carNames = racingGame.splitCarName(carNameInput);
        racingGame.setCar(racingGame.setCarName(carNames));

        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberOfGames = Console.readLine();
        int gameCount = Integer.parseInt(numberOfGames);
        if(gameCount <= 0) throw new IllegalArgumentException();

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