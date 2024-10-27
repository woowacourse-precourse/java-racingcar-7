package racingcar;

public class AfterRacing {

    public static void makeResultString(String carName, boolean isMoving){
        StringBuilder stringBuilder  = new StringBuilder().append(carName).append(" : ");
        if (isMoving) {
            stringBuilder.append("-");
        }
    }
}
