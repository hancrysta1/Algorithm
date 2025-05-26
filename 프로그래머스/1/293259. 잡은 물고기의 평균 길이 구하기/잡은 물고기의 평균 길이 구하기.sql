select cast(avg(if(LENGTH IS NULL,10,LENGTH)) as decimal(10,2)) as AVERAGE_LENGTH
from FISH_INFO;