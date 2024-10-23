package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    static class Car {
        private String name;
        private int distance;
        public Car( String name ){
            this.name = name;
            this.distance = 0;
        }
        String getName() { return this.name; }
        int getDistance() { return this.distance; }
        void drive( int distance ){
            if( distance >= 4 ) this.distance += distance;
        }
    }

    static List<Car> createCarList( String input ){
        StringTokenizer tokenizer = new StringTokenizer( input, "," );
        List<Car> carList = new ArrayList<Car>();
        while( tokenizer.hasMoreTokens() ){
            String name = tokenizer.nextToken();
            if( name.toCharArray().length > 5 ) throw new IllegalArgumentException();
            Car newCar = new Car( name );
            carList.add( newCar );
        }
        return carList;
    }

    static int tryRoll(){
        int result = Randoms.pickNumberInRange( 0, 9 );
        return result;
    }

    static String showMoveLengthToDash( int moveLength ){
        String dash = "";
        for( int index = 0; index < moveLength; index++ ) dash += "-";
        return dash;
    }

    static List<Car> chooseWinner( List<Car> carList ){
        List<Car> winners = new ArrayList<Car>();
        carList.sort(Comparator.comparing( (Car car) -> car.getDistance() ).reversed() );
        int maxScore = carList.get(0).getDistance();
        for( Car car : carList ){
            if( car.getDistance() == maxScore ) winners.add( car );
            else break;
        }
        return winners;
    }

    public static void main(String[] args) {
        System.out.println( "경주할 자동차 이름을 입력하세요.(이름은 쉽고(,) 기준으로 구분)" );
        String input = Console.readLine();
        List<Car> carList = createCarList( input );
        System.out.println( "시도할 횟수는 몇 회인가요?" );
        int count;
        try{ count = Integer.parseInt( Console.readLine() ); }
        catch( NumberFormatException e ){ throw new IllegalArgumentException(); }
        for( int inning = 1; inning <= count; inning++ ){
            for( Car challenger: carList ){
                int moveLength = tryRoll();
                System.out.println( challenger.getName() + " : " + showMoveLengthToDash( moveLength ) );
                challenger.drive( moveLength );
            }
            System.out.println();
        }
        System.out.print( "최종 우승자 : " );
        List<Car> winners = chooseWinner( carList );
        if( winners.size() == 1 ) System.out.print( winners.get(0).getName() );
        else if( winners.size() > 1 ) {
            System.out.print( winners.get(0).getName() );
            for( int index = 1; index <= winners.size() - 1; index++ ){ System.out.print( ", " + winners.get(index).getName() ); }
        }
    }
}
