package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.Car;

public class GetInput {

    public void GetInput(){
        List<Car> cars= new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameset= Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int count= Integer.parseInt(Console.readLine());


        String[] checkedname = nameset.split(",");

        validateNameLength(checkedname);
        
        for (String carname : checkedname) {
            cars.add(new Car(carname.trim(),0,""));
        }
    }

    public static void validateNameLength(String[] checkedname){
        for (String name : checkedname) {
            if(name.length()>5){throw new IllegalArgumentException();}
        }

    }



}
