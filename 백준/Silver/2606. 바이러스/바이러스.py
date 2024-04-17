n=int(input())+1
pair=int(input())
graph=[[0]*n for _ in range(n)]
for _ in range(pair):
    fromN,toN = map(int,input().split())
    graph[fromN][toN] = 1
    graph[toN][fromN] = 1
    

def dfs(num,n,graph,visited,count):
    visited[num]=True
    
    for j in range(n):
        if graph[num][j]==1 and not visited[j]:
            count.append(j)
            dfs(j,n,graph,visited,count)
    return count
    

def solution(n, graph):
    answer = 0
    count=[]
    visited=[False]*n
    if not visited[1]:
        answer = len(dfs(1,n,graph,visited,count))
    return answer

print(solution(n,graph))