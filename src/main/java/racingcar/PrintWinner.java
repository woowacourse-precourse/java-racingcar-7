package racingcar;

import java.util.ArrayList;
import java.util.List;

public class PrintWinner {
    public PrintWinner() { }

    public void finishGame(List<Car> cars) {
        List<Car> Winner = checkWinner(cars);
        print(Winner);
    }

    private List<Car> checkWinner(List<Car> cars) {
        List<Car> Winner = new ArrayList<>();
        int maxAdvance = 0;

        for(int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getAdvance() > maxAdvance) {
                maxAdvance = cars.get(i).getAdvance();
                Winner.clear();
                Winner.add(cars.get(i));
            }
            else if(cars.get(i).getAdvance() == maxAdvance) {
                Winner.add(cars.get(i));
            }
            else continue;
        }

        return Winner;
    }

    private void print(List<Car> Winner) {
        String output = "";
        for(int i = 0; i < Winner.size(); i++) {
            output += Winner.get(i).getName() + ", ";
        }
        output = output.substring(0, output.length() - 2);
        System.out.println("최종 우승자 : " + output);
    }
}
