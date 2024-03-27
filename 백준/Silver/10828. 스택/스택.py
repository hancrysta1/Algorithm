import sys

my_stack=[]
def push(x):
    my_stack.append(x)

def empty():
    if(len(my_stack)==0): return 1
    else: return 0
    
def pop():
    if(empty()):
        return -1
    else:
        return my_stack.pop()

def size(): return len(my_stack)

def top():
    if(empty()):
        return -1
    else:
        return my_stack[-1]
    

N = int(input())
result=[]
for i in range(N):
    order = input()
    if order.split()[0] == "push":
        result.append(push(int(order.split()[1])))
    elif order == "pop":
        result.append(pop())
    elif order == "size":
        result.append(size())
    elif order == "empty":
        result.append(empty())
    elif order == "top":
        result.append(top())
        
for i in result:
    if i != None:
        print(i)
        