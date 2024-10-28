# java-racingcar-precourse

### 기능 목록
1. 사용자 입력
   - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다
   - [x] 경주할 자동차 이름을 입력 받는다.
   - [x] 자동차 이름은 쉼표(,) 기준으로 구분하며 5자 이하만 가능하다.
   - [x] 몇 번을 이동할 것인지 시도 횟수를 입력 받는다.
2. 자동차 이동
   - [x] 0에서 9사이의 무작위 값을 구한다.
      - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
   - [x] 무작위 값이 4 이상일 경우 전진한다.
   - [x] 4보다 작은 값일 경우 전진할 수 없다.
3. 자동차 경주 결과 출력
   - [x] 결과 출력 형식은 "{자동차이름} : {이동거리}"이다.
   - [x] 시도가 1회 진행될 때 마다 결과를 출력한다.
   - [x] 최종 결과로 우승한 자동차의 이름을 출력한다. (우승자가 여러명일 경우 쉼표로 구분하여 출력한다.)