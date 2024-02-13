n=int(input())
lt=[]
num=input().split()
for i in range(n):
    lt.append(int(num[i]))

lt.sort()
print(int(lt[n-1])*int(lt[n-2]))