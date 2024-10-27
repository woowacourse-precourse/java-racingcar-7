# java-racingcar-precourse

---
# 자동차 경주 

tring
초간단 자동차 경주 게임을 구현한다. 

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다. 
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항 
- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```java 
pobi,woni,jun
```
- 시도할 횟수 
```java
5
```

**출력** 
- 차수 별 실행결과 
```declarative
pobi : --
woni : ----
jun : ---
```
- 단독 우승자 안내 문구 
```declarative
최종 우승자 : pobi
```
- 공동 우승자 안내 문구 
```declarative
최종 우승자 : pobi, jun
```

**실행 결과 예시**
```declarative
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
```

# 구현 기능 목록 
## Main 
- 입력 : String 자동차 이름들 (,로 나뉘어진 차 이름), 시도 횟수

  - 자동차 이름들과 시도 횟수를 String으로 받아
  - 시도 횟수를 정수형으로 변경 후 시도 횟수 만큼 반복
  - checkCarNameError()함수를 사용하여 5글자 이상의 자동차 이름이 있는지 확인 
  - 자동차 들의 진행상황을 기록하기 위해 carProgressArr 배열을 만든다. 
  - 입력받은 시도 횟수 만큼 반복을 하며, 자동차 마다의 진행 여부를 canProgressWithRandomNum()을 통해 전달 받고 
  - carProgressArr에 저장 및 printCarNameProgress 함수를 사용해 현재 진행 상황을 출력 
  - 시도 횟수가 끝난다면, 최종 우승자를 getWinners함수를 이용해 찾아내고 출력한다. 
  
- 출력 : 각 시도마다 진행 결과, 최종 우승자 

## checkError()
- [ ] checkCarNameError() : 차 이름이 5글자 넘는지 확인하는 함수  
- [ ] checkRepeatNumError() : 입력된 시도 횟수가 숫자인지 확인하는 함수 
    
## checkCarNameError()
- [x] 자동차 이름이 5글자 넘는 것이 있는지 확인하는 함수 
// 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.  
- splitCarsName 에서 받은 배열을 반복문으로 5자 이상이 넘는지 확인. 

## checkRepeatNumError()
- [ ]  시도 횟수를 입력 했을 때 숫자가 아니면, 에러를 발생 시키는 함수 

## splitCarsName 
- [x] 콤마를 기준으로 차 이름을 배열로 만들어 주는 함수 
- 입력 : String inputStr
  - 입력으로 받은 차 이름들을 (,)을 기준으로 split 
- 출력 : split으로 나눈 차 이름 Array 

## canProgressWithRandomNum()
- [x] 반복 회차마다 차별 진행 여부 random값을 받아 판별 하는 함수
- 입력 : 
  - 자동차가 앞으로 가기위한 조건을 충족하기 위해 
  - 조건이 되는 0에서 9사이의 random값을 생성 
  - 4이상의 random값이 나올 경우
    - ture : 1 
    - false : 0 
- 출력 : 0-9사이의 random한 수

## printCarNameProgress()
- [x] 반복 회차마다 차별 진행 상황 출력하는 함수
- 입력 : 차 이름, 차 진행상황
  - 진행상황을 받아서, "-"를 진행상황에 맞춰 이어준다.(어떻게? - stringbuild ? )
  - println으로 차 이름과 진행상황을 프린트 한다.
- void

## getLargestProgress()
- [x] pregressArr에서 가장 큰 수를 찾아 반환  

## getWinners()
- [x] 우승자 판별하는 함수, getLargestProgress함수에서 받은 수를 사용해서 그 수의 인덱스를 찾아 인덱스를 활용해서 해당 차에 대한 이름을 반환 
