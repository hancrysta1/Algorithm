def solution(n, computers):
    answer=0
    visited=[False]*n #방문여부 확인하는 배열
    for i in range(n):
        if not visited[i]:
            stack=[i]
            
            while stack:
                current=stack.pop()
                visited[current]=True
                for j in range(n):
                    if computers[current][j]==1 and not visited[j]:
                        stack.append(j)
            answer+=1
    return answer