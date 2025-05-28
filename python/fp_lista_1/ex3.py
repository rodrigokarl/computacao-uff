salario = float(input())
if salario > 0 and salario <= 400.00:
    reajuste = salario * 0.15
    novo_salario = salario + reajuste
    percentual = 15
elif salario > 400.00 and salario <= 800.00:
    reajuste = salario * 0.12
    novo_salario = salario + reajuste
    percentual = 12
elif salario > 800.00 and salario <= 1200.00:
    reajuste = salario * 0.10
    novo_salario = salario + reajuste
    percentual = 10
elif salario > 1200.00 and salario <= 2000.00:
    reajuste = salario * 0.07
    novo_salario = salario + reajuste
    percentual = 7
else:
    reajuste = salario * 0.04
    novo_salario = salario + reajuste
    percentual = 4
print(f"Novo salario: {novo_salario:.2f}")
print(f"Reajuste ganho: {reajuste:.2f}")
print(f"Percentual: {percentual}%")
