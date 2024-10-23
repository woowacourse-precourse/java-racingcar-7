package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Contest {
    private  ArrayList<Car> cars = new ArrayList();
    private static int gameNum = 0;

    public Contest() {//생성자
        System.out.println("경주할 자동차 이름을 입력하세요.");
    }

    public void input() {
        String inputCars = Console.readLine();
        String[] carNmaes = inputCars.trim().split(",");

        for(String name : carNmaes) {
            Car car = new Car(name);
            cars.add(car);
        }

        gameNum = Integer.valueOf(Console.readLine().trim());

    }
    public void gameStart() {
        for (int i = 0; i < gameNum; i++) {
            this.gamePlay();
        }
    }
    private void gamePlay(){
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) { //0~9 정수 중 한 개
                car.move();
            }
        }
    }
    public void gameEnd() {
        for (Car car : cars) {
            System.out.printf("%s : %d%n",car.getName(),car.getPos());
        }

    }
}