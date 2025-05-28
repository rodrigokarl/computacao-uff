a = int(input())
for y in range(a):
    divisores = []
    n = int(input())
    for x in range(1, n):
        if n % x == 0:
            divisores.append(x)
    if sum(divisores) == n:
        print(f"{n} eh perfeito")
    else:
        print(f"{n} nao eh perfeito")
