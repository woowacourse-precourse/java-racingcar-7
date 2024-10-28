package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        final String INPUT_CARNAME = Console.readLine();
        validateCarName(INPUT_CARNAME);

        System.out.println("시도할 횟수는 몇회인가요?");
        final String INPUT_TRY_COUNT = Console.readLine();
        validateTryCount(INPUT_TRY_COUNT);

        ProgressMap progressMap = new ProgressMap(INPUT_CARNAME.split(",").length);
        initializeProgressMap(progressMap, INPUT_CARNAME);

        System.out.println("\n실행 결과");
        racingGame(progressMap, Integer.parseInt(INPUT_TRY_COUNT));

        announceWinners(progressMap);
    }

    private static void racingGame(ProgressMap progressMap, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveAllCars(progressMap);
            progressMap.printProgress();
            System.out.println();
        }
    }

    private static void moveAllCars(ProgressMap progressMap) {
        for (int i = 0; i < progressMap.size; i++) {
            if (getRandomNumber()) {
                progressMap.incrementProgress(i);
            }
        }
    }

    private static void initializeProgressMap(ProgressMap progressMap, String carNames) {
        for (String name : carNames.split(",")) {
            progressMap.add(name.trim(), 0);
        }
    }

    private static boolean getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private static void validateCarName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 필수입니다.");
        }
        for (String name : carName.split(",")) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
            }
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    private static void validateTryCount(String tryCount) {
        try {
            if (tryCount == null || tryCount.trim().isEmpty()) {
                throw new IllegalArgumentException("시도 횟수는 필수입니다.");
            }
            int count = Integer.parseInt(tryCount);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void announceWinners(ProgressMap progressMap) {
        int maxProgress = progressMap.getMaxProgress();
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        boolean first = true;

        for (int i = 0; i < progressMap.size; i++) {
            if (progressMap.getProgress(i) == maxProgress) {
                if (!first) {
                    winners.append(", ");
                }
                winners.append(progressMap.getName(i));
                first = false;
            }
        }
        System.out.println(winners);
    }

    private static class ProgressMap {
        private String[] names;
        private int[] progressCounts;
        private int size;
        private int capacity;

        public ProgressMap(int initialCapacity) {
            this.capacity = initialCapacity;
            this.names = new String[initialCapacity];
            this.progressCounts = new int[initialCapacity];
            this.size = 0;
        }

        public void add(String name, int count) {
            if (size >= capacity) {
                grow();
            }
            names[size] = name;
            progressCounts[size] = count;
            size++;
        }

        private void grow() {
            int newCapacity = capacity * 2;
            String[] newNames = new String[newCapacity];
            int[] newProgressCounts = new int[newCapacity];

            for (int i = 0; i < size; i++) {
                newNames[i] = names[i];
                newProgressCounts[i] = progressCounts[i];
            }

            names = newNames;
            progressCounts = newProgressCounts;
            capacity = newCapacity;
        }

        public void incrementProgress(int index) {
            if (index >= 0 && index < size) {
                progressCounts[index]++;
            }
        }

        public int getProgress(int index) {
            return progressCounts[index];
        }

        public String getName(int index) {
            return names[index];
        }

        public int getMaxProgress() {
            int max = 0;
            for (int i = 0; i < size; i++) {
                if (progressCounts[i] > max) {
                    max = progressCounts[i];
                }
            }
            return max;
        }

        public void printProgress() {
            for (int i = 0; i < size; i++) {
                System.out.print(names[i] + " : ");
                for (int j = 0; j < progressCounts[i]; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
        }
    }
}