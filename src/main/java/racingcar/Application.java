package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Application {
    static List<Car> cars = new ArrayList<>();
    static int playCount;
    static int count;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String str = Console.readLine();
        playCount = Integer.parseInt(Console.readLine());
        
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

                if(randomNum >= 4) {
                    cars.get(j).location += 1;
                }
            }

            for (int j = 0; j < count; j++) {
                System.out.print(cars.get(j).getInfo());
            }
            System.out.println();
        }
    }

    static void printWinner() {
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp = Math.max(temp, cars.get(i).location);
        }

        List<String> winner = new ArrayList<>();
        if(temp != 0){
            for (int i = 0; i < count; i++) {
                if(cars.get(i).location == temp) {
                    winner.add(cars.get(i).name);
                }
            }
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
}
