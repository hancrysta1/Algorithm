-- 코드를 작성해주세요
#2진수가 힌트고 핵심!!
select DISTINCT D.id,D.email,D.FIRST_NAME,D.LAST_NAME 
from DEVELOPERS D join SKILLCODES S
 #비트마스크 연산(교집합 이진수형태로 리턴)
on (d.skill_code&s.code)>0
where s.name in ('C#','Python')
order by d.id asc;