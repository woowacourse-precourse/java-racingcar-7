package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

    static class Car {
        private String name;
        private int distance;
        public Car( String name ){
            this.name = name;
            this.distance = 0;
        }
        String getName() { return this.name; }
        void drive( int distance ){
            this.distance += distance;
        }
    }

    static List<Car> createCarList( String input ){
        StringTokenizer tokenizer = new StringTokenizer( input, "," );
        List<Car> carList = new ArrayList<Car>();
        while( tokenizer.hasMoreTokens() ){
            Car newCar = new Car( tokenizer.nextToken() );
            carList.add( newCar );
        }
        return carList;
    }

    static int tryRoll(){
        int result = Randoms.pickNumberInRange( 0, 9 );
        if( result >= 4 ) return result;
        else return 0;
    }

    static String showMoveLengthToDash( int moveLength ){
        String dash = "";
        for( int index = 0; index < moveLength; index++ ) dash += "-";
        return dash;
    }

    public static void main(String[] args) {
        System.out.println( "경주할 자동차 이름을 입력하세요.(이름은 쉽고(,) 기준으로 구분)" );
        String input = Console.readLine();
        List<Car> carList = createCarList( input );
        System.out.println( "시도할 횟수는 몇 회인가요?" );
        int count = Integer.parseInt( Console.readLine() );
        for( int inning = 1; inning <= count; inning++ ){
            for( Car challenger: carList ){
                int moveLength = tryRoll();
                System.out.println( challenger.getName() + " : " + showMoveLengthToDash( moveLength ) );
                challenger.drive( moveLength );
            }
            System.out.println();
        }
        System.out.println( "실행 결과" );
    }
}
