package racingcar;
import java.util.ArrayList;

public class View {
    private ArrayList<Car> cars;

    public View( ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void printCars() {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            for(int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void printNameScript(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public void printNumberScript(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }
    public void printWinner(){
        ArrayList<String> winnersName = new ArrayList<>();
        int winnerScore = 0;

        System.out.print("최종 우승자 : ");

        for (Car car : cars) {
            if(winnerScore < car.getPosition()){
                winnerScore = car.getPosition();
            }
        }
        for (Car car : cars) {
            if(winnerScore == car.getPosition()){
                winnersName.add(car.getCarName());
            }
        }
        for (int i = 0; i < winnersName.size(); i++) {
            if(i == 0){
                System.out.print(winnersName.get(i));
            }
            else {
                System.out.print(", " +winnersName.get(i));
            }
        }

    }
}
