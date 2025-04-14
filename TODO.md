# 요구사항 리스트  

## Domain

### Users (유저)
- [x] 검증 (빈 값 검증, 아이디 띄어쓰기, 한글 입력 시 예외)

### TodoCategory (Todo 대분류)
- [ ] 검증

### Todo 
- [x] 검증 (빈 값)


### Schedule (일정)
- [ ] 검증 (빈 값 검증)

## Service

### UserService
- [ ] 이미 가입된 회원 이라면 예외

### TodoService
- [ ] 조회, 수정 삭제 중 유저의 Todo 아닐 시 예외


### ScheduleService
- [ ] 조회, 수정 삭제 중 유저의 할 일 아닐 시 예외

## Repository
- [ ] 유저로 TODO, 할 일 리스트 조회 (상태 별, 날짜 별)


