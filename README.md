
<p>
    <img src="https://github.com/user-attachments/assets/c811c2be-923e-4134-a7d4-56bd12198910" alt="우아한테크코스" width="300px">
</p>

# 프리코스 2주차 미션 - 자동차 경주

---

##  💪 미션 개요
1. 경주할 자동차 이름과, 시도횟수를 입력받는다.
2. 자동차들은 시도 회차마다 전진을 시도한다.(일정확률로 전진)
2. 차수별로 실행 결과를 출력한다.
3. 최종 우승자를 출력한다.

# 📝기능 목록

- [ ] 경주할 자동차 이름을 입력 받는 기능
    - `출력문구`: "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    - 이름은 쉼표(,) 기준으로 구분한다.<br><br>

- [ ] 시도 횟수를 입력 받는 기능
  - `출력문구`: "시도할 횟수는 몇 회인가요?"<br><br>
  
- [ ] 자동차 전진하는 기능
  - 전진하는 조건: 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.<br><br>
 
- [ ] 시도 회차 별로 실행 결과 출력 기능
    - `출력예시`<br>
      실행 결과<br>
      pobi : -<br>
      woni :<Br>
      jun : -<br><br>

- [ ] 최종 우승자를 출력 기능
  - `출력예시`: "최종 우승자 : pobi"
  - 공동우승자인경우: "최종 우승자 : pobi, jun" <br><br>


## ⚡예외 발생 사안
`사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.`

- 경주할 자동차 이름을 입력 받는 기능
- [ ] 예외처리: 이름이 5자 초과시 예외처리.
- [ ] 예외처리: 빈값을 입력한 경우
- [ ] 예외처리: 알파벳 이외의 문자가 들어간 경우.<br><br>


## 🙋‍♂️스스로 판단해본 기능 요구 사항

