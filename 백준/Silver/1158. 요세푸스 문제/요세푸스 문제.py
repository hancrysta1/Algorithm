from collections import deque

N,K = map(int,input().split())
new_circle = deque(range(1, N + 1))

def removeCircle(K):
    resultarr = []
    while new_circle:
        
        for _ in range(K-1):#축을 돌리는 역할
            new_circle.rotate(-1)
            #K-1까지 -1씩(왼쪽으로) 큐 회전, front는 우측으로 이동한다. 
                
        resultarr.append(new_circle.popleft())#K-1에서 popleft = K번째 요소 popleft
        
    return resultarr

answer = removeCircle(K)
answerString='<'
for i in answer:
    if i is not answer[-1]:
        answerString+=str(i)+', '
    else:
        answerString+=str(i)+'>'
print(answerString)

    

