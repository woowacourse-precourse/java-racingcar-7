# java-racingcar-precourse
# java-racingcar-precourse

1. **자동차 이름 입력 기능**<br>
   -사용자가 경주할 자동차의 이름을 입력할 수 있습니다.<br>
   -자동차 이름은 쉼표로 구분하며, 각 이름은 5자 이하만 가능합니다.<br>
   -잘못된 이름이 입력될 경우 IllegalArgumentException이 발생합니다.

2. **시도 횟수 입력 기능**<br>
   -사용자가 시도할 횟수를 입력할 수 있습니다.<br>
   -시도 횟수는 0보다 큰 정수여야 하며, 잘못된 값이 입력되면 IllegalArgumentException이 발생합니다.

3. **자동차 전진 로직**<br>
   -무작위 값을 0에서 9 사이에서 생성하며, 값이 4 이상이면 자동차가 전진합니다.<br>
   -전진하는 경우 자동차의 현재 위치를 "-"로 표시합니다.

4. **경주 진행 및 상태 출력**<br>
   -입력된 시도 횟수만큼 자동차들이 경주를 진행합니다.<br>
   -각 시도 후 자동차의 현재 상태를 출력합니다.

5. **최종 우승자 결정 및 출력**<br>
   -경주가 종료되면 가장 멀리 이동한 자동차가 우승자로 결정됩니다.<br>
   -공동 우승자가 있을 경우, 쉼표로 구분하여 출력합니다.

6. **무작위 값 추출**<br>
   -camp.nextstep.edu.missionutils.Randoms.pickNumberInRange()를 사용하여 0에서 9 사이의 무작위 값을 생성합니다.

7. **사용자 입력 처리**<br>
   -camp.nextstep.edu.missionutils.Console.readLine()을 통해 사용자 입력을 받습니다.