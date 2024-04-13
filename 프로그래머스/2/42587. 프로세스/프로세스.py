from collections import deque

def solution(priorities, location):
    q=deque()
    #q = [(i,p) for i,p in enumerate(priorities)]
    
    for i,p in enumerate(priorities):
        q.append((i,p))
    answer = 0
    while True:
        item=q.popleft()
        if any(item[1] < e[1] for e in q): #n중 1이라도 있다면(복수 조건)
            q.append(item)
        else:
            answer+=1
            if item[0]==location:
                return answer
            
            