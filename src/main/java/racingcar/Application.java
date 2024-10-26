
package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int maximum=0;
        int checkingnum=0;
        List<String> winnerList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameset= Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count= Integer.parseInt(Console.readLine());

        String[] checkedname = nameset.split(",");
        for (String name : checkedname) {
            if(name.length()>5){
                throw new IllegalArgumentException();
            }
        }
        //List<String> name= Arrays.asList(nameset.split(","));
        List<Car> cars= new ArrayList<>();

        for (String s : checkedname) {
            cars.add(new Car(s.trim(),0,""));
        }

        System.out.println("실행 결과");
        for(int i=0; i<count; i++) {

            for (Car car : cars) {
                if(Randoms.pickNumberInRange(0, 9)>=4){
                    car.length++;
                    car.distance+="-";
                }
                System.out.println(car);
            }
            System.out.println();
        }

        for (Car car : cars) {
            if(car.length>maximum){
                maximum=car.length;
            }
        }

        System.out.print("최종 우승자 : ");
        for(int i=0; i<cars.size(); i++) {

            if (maximum == cars.get(i).length) {
                winnerList.add(cars.get(i).name);
            }
        }

        if(winnerList.size()>1){
            for(int i=0; i<winnerList.size(); i++){
                System.out.print(winnerList.get(i));
                if(i<winnerList.size()-1){
                    System.out.print(", ");
                }
            }
        }
        if(winnerList.size()==1){
            System.out.print(winnerList.get(0));
        }
    }
}
