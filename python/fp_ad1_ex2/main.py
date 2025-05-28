qtdTestes = input("Digite a quantidade de testes\n")
qtdValoresTeste = input("Digite a quantidade de valores de cada teste\n")
valorMinimo = input("Digite o valor mínimo do intervalo\n")
valorMaximo = input("Digite o valor máximo do intervalo\n")

i = 0
for i in range(int(qtdTestes)):
    valoresTestes = input("Digite os valores do teste atual\n").split()
    abaixoIntervalo = 0
    acimaIntervalo = 0
    dentroIntervalo = 0
    somaIntervalo = 0
    j = 0
    for j in range(int(qtdValoresTeste)):
        if float(valoresTestes[j]) < float(valorMinimo):
            abaixoIntervalo += 1
        elif (float(valoresTestes[j]) >= float(valorMinimo)) and (float(valoresTestes[j]) <= float(valorMaximo)):
            dentroIntervalo += 1
            somaIntervalo += float(valoresTestes[j])
        elif float(valoresTestes[j]) > float(valorMaximo):
            acimaIntervalo += 1

    print(f'Intervalo: [{valorMinimo}, {valorMaximo}]')
    print(f'Abaixo do Intervalo: {abaixoIntervalo}, No Intervalo: {dentroIntervalo}, Acima do Intervalo: {acimaIntervalo}.')
    print(f'Soma dos Valores Dentro do Intervalo: {somaIntervalo}.')