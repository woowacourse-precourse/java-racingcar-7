# java-racingcar-precourse

## 기능 요구 사항
### 입출력
+ 자동차 이름은 쉼표를 기준으로 구분하며 이름은 5자 이하만 가능하다
+ 몇 번의 이동을 할 것인지 입력한다
+ 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다

### 자동차 전진하기
+ 랜덤 값 추출은 camp.nextstep.edu.missionutils 에서 제공하는 Randoms.pickNumberInRange() 사용한다
+ 매 라운드에서 0-9사이에서 무작위 값을 구한 후 무작위 값이 4일 경우 전진한다
  
### 우승자 발표
+ 우승자가 여러 명일 경우 쉼표를 이용해 구분한다
+ 가장 큰 이동값을 가진 자동차의 위치와 같은 위치에 있는 자동차가 있는지 확인한다

![RacingCar](https://github.com/user-attachments/assets/5e43a906-666c-4260-9104-f7d2b145815d)

