package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Contest {
    private ArrayList<Car> cars = new ArrayList();
    private int gameNum = 0;

    public Contest() {//생성자
        System.out.println("경주할 자동차 이름을 입력하세요.");
    }

    public void input() {
        String inputCars = Console.readLine();
        String[] carNmaes = inputCars.split(",");

        for(String name : carNmaes) {
            Car car = new Car(name.trim());
            cars.add(car);
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        gameNum = Integer.valueOf(Console.readLine().trim());

    }
    public void gameStart() {
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < gameNum; i++) {
            this.gamePlay();
            gameInfoPrint();
            System.out.println();
        }
        gameEnd();
    }
    private void gamePlay(){
        for (Car car : cars) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) { //0~9 정수 중 한 개
                car.move();
            }
        }
    }
    public void gameInfoPrint(){
        for (Car car : cars) {
            System.out.printf("%s : %s%n", car.getName(), car.getDistance());
        }
    }

    private String winner() {
        int maxDistance = -1;
        StringBuilder winnerBuilder = new StringBuilder();

        for (Car car : cars) {
            int distance = car.getPos();

            if (distance > maxDistance) {
                maxDistance = distance;
                winnerBuilder.setLength(0);
                winnerBuilder.append(car.getName());
            } else if (distance == maxDistance) {
                winnerBuilder.append(",").append(car.getName());
            }
        }

        return winnerBuilder.toString();
    }
    public void gameEnd() {
        System.out.println("최종 우승자 : "+ winner());
    }
}