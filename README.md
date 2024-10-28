# 자동차 경주 -minhyuk2

# 기능 요구 사항
## 초간단 자동차 경주 게임을 구현한다.

 - 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 - 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
 - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은<span style="color: orange;"> 5자 이하만 가능하다.
 - 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 - 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이<span style="color: orange;">4 이상</span>일 경우이다.
 - 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는  <span style="color: orange;">한 명 이상일 </span>수 있다.
 - 우승자가 여러 명일 경우 <span style="color: orange;">쉼표(,)</span>를 이용하여 구분한다.
 - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.


# 입출력 요구 사항
## 입력
 - 경주할 자동차이름은 ,로 구분되어 나타난다.
   <p style="color: orange;">pobi, woni, jun</p> 
- 아래에 시도할 횟수를 입력받습니다.


## 출력
- 차수별 실행결과 \
  pobi : --\
  woni : ----\
  jun : ---


- 단독 우승자 안내 문구

  최종 우승자 : pobi


- 공동 우승자 안내 문구\
  최종 우승자 : pobi, jun
# 입출력 예시 
    경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
    pobi,woni,jun
    시도할 횟수는 몇 회인가요?
    5
    
    실행 결과
    pobi : -
    woni :
    jun : -
    
    pobi : --
    woni : -
    jun : --
    
    pobi : ---
    woni : --
    jun : ---
    
    pobi : ----
    woni : ---
    jun : ----
    
    pobi : -----
    woni : ----
    jun : -----
    
    최종 우승자 : pobi, jun


# 라이브러리
    - camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

# 구현 기능

## 필요한 부분들
 - 입력받는 부분 구현 -> 쉼표에 따라서 구분될 수 있도록 1주차의 split함수를 응용하여 구현
 시도한 횟수를 입력 받기 -> 시도한 횟수만큼만 실행할 수 있도록

 
 - 출력 부분 구현 입력 받은 실행횟수만큼만 실행하여 결과가 나올 수 있도록 함
 - 랜덤 함수로 결과가 나오게끔 구현 -> 각 자동차마다 int goStraight 변수를 할당해서 늘려나감
 - 변수의 개수마다 매 라운드마다 -를 출력하도록 해줌
 - View를 구현해서 input,output 나눠서 입력받기


 - 마지막 라운드가 끝나고 goStraight 변수의 크기를 비교하여 우승자를 선정함, max함수를 사용해서 가장 큰 값을 뽑고
 - 자동차 리스트를 돌면서 가장 큰 값을 가진 자동차 명을 또 다른 리스트에 저장후 마지막에 우승자로 출력

## 구현 기능 정리
1. 이름을 입력받아서 ,로 구분하여 list로 만드는 기능 구현


2. 시도할 횟수를 입력받아서 저장하는 기능 구현


3. 안내문을 출력하는 기능 구현


4. 랜덤함수를 통해서 각 라운드마다 랜덤값을 부여받고, 해당 값에 따라 전진하는지 판단하는 기능 구현


5. 한 라운드가 진행 되고 나서 위에서 판단한 전진 값만큼 '-'를 출력하는 기능 구현


6. 모든 라운드가 끝나고 가장 큰 값을 가진 자동차들을 찾아내는 기능 구현


7. 가장 큰 값과 같은 값을 가진 자동차들을 최종 우승자로 출력하는 기능 구현


8. 예외처리와 테스트케이스에 대한 예외처리 진행



# 예외 처리
 - 라운드가 빠르게 종료되었거나 아무도 전진하지 못해서 모두가 같이 0인 경우에는 전부 우승자로 처리 -> 다른 출력에 대한 요구사항이 없기떄문에
 - 예외처리로 사이에 공백이 나온 경우 공백 앞뒤로만 없앨지 말지고민 문자 중간의 공백은 허용하지만 앞 뒤로 발생하는 공백제거
 - 음수 시도 값을 입력하였을 경우에 대한 예외처리 -> IllegalArgumentException 으로 종료
 - 이름이 하나도 입력되지 않았을 경우에 대한 예외처리 -> 공백으로만 입력하였을 경우


 
 # 디렉토리 구조
```angular2html
./src
├── main
│   └── java
│       └── racingcar
│           ├── Application.java
│           ├── controller
│           │   └── RacingCarController.java
│           ├── domain
│           │   ├── CarDTO.java
│           │   ├── InputDTO.java
│           │   └── RoundTimeDTO.java
│           ├── service
│           │   └── RacingCarService.java
│           └── view
│               └── RacingCarView.java
└── test
    └── java
        └── racingcar
            └── ApplicationTest.java
```
