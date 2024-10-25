package util;

public class Output {

    public static void printRaceStatus(Car[] cars, int repeatCount) {
        for (Car car : cars) {
            String carName = car.getName();
            int forwardCount = car.getForwardCount(repeatCount);
            String raceStatus = returnRaceStatus(forwardCount);

            System.out.println(carName + " : " + raceStatus);
        }
        System.out.println();
    }

    private static String returnRaceStatus(int forwardCount) {
        String forwardStatus = "";
        for (int i = 0; i < forwardCount; i++) {
            forwardStatus += "-";
        }

        return forwardStatus;
    }
}
