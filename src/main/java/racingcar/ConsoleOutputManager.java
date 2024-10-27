package racingcar;

import java.util.List;

public class ConsoleOutputManager implements OutputManager {
    @Override
    public void printExecutionResult(List<Car> progressResult) {
        System.out.println();
        System.out.println("실행 결과");

        for(Car car : progressResult){
            int distance = car.getDistance();
            String name = car.getName();

            System.out.print(name+" : ");
            for(int i = 0; i < distance; i++){
                System.out.print("-");
            }

            System.out.println();
        }
    }

    @Override
    public void printWinner(List<Car> winner) {
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winner.size(); i++){
            if(i != winner.size()-1){
                System.out.print(winner.get(i).getName()+", ");
            } else {
                System.out.println(winner.get(i).getName());
            }
        }
    }
}
