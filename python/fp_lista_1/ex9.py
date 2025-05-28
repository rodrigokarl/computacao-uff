
def f1(x, y):
    result = pow(3 * x, 2) + pow(y, 2)
    return result

def f2(x, y):
    result = pow(x, 2) * 2 + pow((5 * y), 2)
    return result

def f3(x, y):
    result = (-100 * x) + pow(y, 3)
    return result

n = int(input())

for i in range(n):
    a, b = map(int, input().split())
    c = f1(a, b)
    d = f2(a, b)
    e = f3(a, b)
    if (c > d) and (c > e):
        print("Rafael ganhou")
    elif (d > c) and (d > e):
        print("Beto ganhou")
    elif (e > c) and (e > d):
        print("Carlos ganhou")
