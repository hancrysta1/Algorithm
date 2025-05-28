select count(a.FISH_TYPE) as FISH_COUNT, b.FISH_NAME
from FISH_INFO a
join FISH_NAME_INFO b on a.FISH_TYPE=b.FISH_TYPE
group by a.FISH_TYPE,b.FISH_NAME
order by FISH_COUNT desc;