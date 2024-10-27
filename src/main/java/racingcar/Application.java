package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Application {
    static List<Car> cars;
    static int playCount;
    static int count;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();
        playCount = Integer.parseInt(Console.readLine());
        cars = new ArrayList<>();

        createCar(str);

        playGame();

        printWinner();
    }
    static void createCar(String str) {
        StringTokenizer st = new StringTokenizer(str,",");
        count = st.countTokens();

        for (int i = 0; i < count; i++) {
            String name = st.nextToken();
            if(name.length() < 5 ) {
                cars.add(new Car(name));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    static void playGame() {
        for (int i = 0; i < playCount; i++) {
            for (int j = 0; j < count; j++) {
                int randomNum = Randoms.pickNumberInRange(0,9);
                recordLoc(j, randomNum);
            }
            printLoc();
        }
    }

    static void recordLoc(int carNum, int randomNum) {
        if(randomNum >= 4) {
            cars.get(carNum).location += 1;
        }
    }

    static void printLoc() {
        for (int j = 0; j < count; j++) {
            System.out.print(cars.get(j).getInfo());
        }
        System.out.println();
    }

    static void printWinner() {

        int winnerLoc = getWinnerLoc();

        List<String> winner = new ArrayList<>();
        if(winnerLoc != 0){
            winner = getWinner(winnerLoc);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        sb.append(winner.getFirst());
        for (int i = 1; i < winner.size(); i++) {
            sb.append(", ");
            sb.append(winner.get(i));
        }

        System.out.println(sb);
    }

    static int getWinnerLoc() {
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp = Math.max(temp, cars.get(i).location);
        }
        return temp;
    }

    static List<String> getWinner(int winnerLoc) {
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if(cars.get(i).location == winnerLoc) {
                winner.add(cars.get(i).name);
            }
        }
        return winner;
    }
    
}
