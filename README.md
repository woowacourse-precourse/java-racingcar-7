# java-racingcar-precourse
해당 프로젝트는 사용자의 입력에 따라 진행하는 초간단 자동차 경주 게임을 구현하는 것을 목표로 한다.

<br>

# To do List
- [x] 입력 안내 메시지 출력
- [x] 사용자 문자열 입력 받기
- [x] 자동차 이름 저장
- [ ] 무작위 값 구하기
- [ ] 경주 결과 출력
- [ ] 우승자 확인
- [ ] 실행 오류 반환 및 출력

<br>

# 프로젝트 요구사항 정의
[해당 문서 참조](./Docs/requirement.md)

<br>

# Commit Message Convention
[해당 문서 참조](./Docs/commit.md)

<br>

# 구현 함수 목록 및 설명
해당 목차 설명은 개발을 수행하며, 추가 및 수정하도록 한다.

| Method Name | Description |
| --- | --- |
| ```void setArguments()``` | 프로그램을 수행하기 위해 사용자에게 문자열을 입력받습니다. |
| ```List<String> splitCarNameString(String inputString)``` | 사용자에게 입력받은 이름 문자열을 지정된 구분자를 활용하여 구분한 후, List로 반환합니다. |
| ```void setStateMap(List<String> nameList)``` | 이름 List를 경주할 자동차로 등록합니다. |