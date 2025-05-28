def prob(a, b):
    return a / (b * 6)

qtdcasos = int(input())

for i in range(qtdcasos):
    guess, dice = map(int, input().split())
    prob(guess, dice)
