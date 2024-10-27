package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class RacingGame {

    List<Car> cars;
    int count;

    public RacingGame(int playCount) {
        cars = new ArrayList<>();
    }

    public void createCar(String str) {
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

    public String playGame() {
        for (int j = 0; j < count; j++) {
            int randomNum = Randoms.pickNumberInRange(0,9);
            recordLoc(j, randomNum);
        }
        return printLoc();

    }

    public String printWinner() {

        int winnerLoc = getWinnerLoc();

        List<String> winner = new ArrayList<>();
        if(winnerLoc != 0){
            winner = getWinnerList(winnerLoc);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        sb.append(winner.getFirst());
        for (int i = 1; i < winner.size(); i++) {
            sb.append(", ");
            sb.append(winner.get(i));
        }

        return sb.toString();
    }

    public void recordLoc(int carNum, int randomNum) {
        if(randomNum >= 4) {
            cars.get(carNum).location += 1;
        }
    }

    public String printLoc() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < count; j++) {
            sb.append(cars.get(j).getInfo());
        }
        sb.append("\n");
        return sb.toString();
    }

    public int getWinnerLoc() {
        int temp = 0;
        for (int i = 0; i < count; i++) {
            temp = Math.max(temp, cars.get(i).location);
        }
        return temp;
    }

    public List<String> getWinnerList(int winnerLoc) {
        List<String> winner = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if(cars.get(i).location == winnerLoc) {
                winner.add(cars.get(i).name);
            }
        }
        return winner;
    }


}
