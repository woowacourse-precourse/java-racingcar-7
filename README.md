# java-racingcar-precourse
# 자동차 경주

# 설계
View : Console <br>
어떤 게임을 할건지 받고 게임기를 켜준다

Controller : PlayStation <br>
게임을 시작하고 끝낸다

Service : RacingGame <br>


Repository, Domain : Cars, Car<br>
현재는 List<Car>로 구현하지만 DB로 변경할 수 있도록 설계
Car : 이름, 위치, move 메서드를 포함

# 기능
1. 자동차 이름 입력
2. 시도할 횟수 입력
3. 자동차 객체 생성
4. 자동차 이름을 검증
   1. 자동차 이름은 5자 이하
   2. 자동차 이름은 공백이 아님
   3. 자동차 이름은 중복되지 않음
5. 생성한 자동차를 List에 저장
6. 시도 횟수만큼 경주 실행
7. pickNumberInRange(0,9)를 통해 랜덤값으로 전진하는 기능
8. 가장 큰값을 찾고, 우승자를 결과에 저장
9. 결과 출력
