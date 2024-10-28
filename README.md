# 프리코스 2주차 미션 - 자동차 경주

***

### 기능 요구 사항

***

초간단 자동차 경주 게임을 구현한다.

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

***

### 구현할 기능

* [x] 사용자에게 `,`로 구분된 한 줄로 이어진 자동차 이름들을 입력받는다.
* [x] 입력받은 이름을 `,`로 나눠서 분리한다.
* [x] 이름의 길이가 5보다 작은 경우 `IllegalArgumentException`예외를 발생시킨다.
* [x] 체크한 이름을 기반으로 Car 객체를 생성하고 리스트에 삽입한다.
* [x] 시도할 횟수를 입력받는다.
* [x] 1보다 작은 횟수가 입력된 경우 `IllegalArgumentException`예외를 발생시킨다.
* [x] 자동차 리스트를 순회하며 `move` 함수를 호출한다.
* [x] 0과 9사이 범위의 랜덤 숫자를 뽑아 4 이상의 숫자가 나오면 `score`에 1점을 더한다.
* [x] 자동차 리스트 순회가 끝나면 차수별 실행 결과를 출력한다.
* [x] 입력받은 횟수만큼 반복이 끝나면 자동차 리스트의 최댓값을 구한다.
* [x] 최댓값을 가지고 있는 자동차 리스트를 가져와 우승자를 출력한다.

***
