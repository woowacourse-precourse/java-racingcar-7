# java-racingcar-precourse

# 기능 요구사항 정리

### 입력
***입력1) 경주할 자동차 이름을 입력한다***
>pobi,woni,jun

✔️입력1 예외사항
1. 쉼표가 존재하는 경우
   - 이름들 중 중복된 이름이 존재하면 IllegalArgumentException을 발생시킨다
   - 이름들 중 하나라도 6자리 이상인 경우 IllegalArgumentException을 발생시킨다
   - 이름이 공백이라면 IllegalArgumentException을 발생시킨다
   

2. 쉼표가 존재하지 않는 경우
   - 이름이 6자리 이상인 경우 IllegalArgumentException을 발생시킨다
   - 공백을 입력하면 IllegalArgumentException을 발생시킨다


✔️입력1 고려사항
- 한글,영어,특수문자 혼용을 허용한다  ex) K5, 포르쉐-911 등 한글,영어,특수문자를 혼용하는 자동차 모델이 존재하고, 모델 이름을 자동차 이름으로 적용할 수 있다.
- 이름에 공백이 있으면 제거하고 게임을 진행한다

***입력2) 게임을 몇 번 진행할지 입력한다***
>5

✔️입력2 예외사항
- 0 이하의 수를 입력하면 IllegalArgumentException을 발생시킨다
- Integer.MAX_VALUE를 초과하는 수를 입력하면 IllegalArgumentException을 발생시킨다
- 숫자가 아닌 것을 입력하면 IllegalArgumentException을 발생시킨다



--- 
### 랜덤 수 생성하기  

Randoms 을 이용하여 0과 9 사이 수를 생성한다

--- 

### 움직이기
랜덤한 수가 4 이상이면 해당 차의 상태에 - 을 더한다

---

### 멈추기
랜덤한 수가 3 이하이면 해당 차의 상태를 유지한다

---
### 우승자 판별하기
게임 결과값을 바탕으로 우승자를 판별한다 

✔️우승자 판별 시 고려사항
- 차 한 대만 입력받으면 해당 차가 우승자이다


- 우승자의 상태는 ""일 수 있다     
  -> m대의 차를 n번 실행했을 때 모두 stop이라면 우승자의 상태는 "" 이다.  

---

### 결과 출력하기
우승자를 출력한다  
>최종 우승자 : pobi, jun