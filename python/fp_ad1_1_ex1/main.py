while True:
    valorTroca = input("Digite um valor maior que 0\n")
    if valorTroca == "":
        break
    elif valorTroca == " ":
        break
    else:
        while valorTroca != "":
            valorTroca = int(valorTroca)
            print(f'Trocando {valorTroca} em:')
            notas100 = valorTroca // 100
            valorTroca = valorTroca % 100
            notas50 = valorTroca // 50
            valorTroca = valorTroca % 50
            notas20 = valorTroca // 20
            valorTroca = valorTroca % 20
            notas10 = valorTroca // 10
            valorTroca = valorTroca % 10
            notas5 = valorTroca // 5
            valorTroca = valorTroca % 5
            notas2 = valorTroca // 2
            valorTroca = valorTroca % 2
            moedas1 = valorTroca // 1
            if notas100 > 0:
                if notas100 > 1:
                    print(f'{notas100} notas de 100 reais')
                else:
                    print(f'{notas100} nota de 100 reais')
            if notas50 > 0:
                if notas50 > 1:
                    print(f'{notas50} notas de 50 reais')
                else:
                    print(f'{notas50} nota de 50 reais')
            if notas20 > 0:
                if notas20 > 1:
                    print(f'{notas20} notas de 20 reais')
                else:
                    print(f'{notas20} nota de 20 reais')
            if notas10 > 0:
                if notas10 > 1:
                    print(f'{notas10} notas de 10 reais')
                else:
                    print(f'{notas10} nota de 10 reais')
            if notas5 > 0:
                if notas5 > 1:
                    print(f'{notas5} notas de 5 reais')
                else:
                    print(f'{notas5} nota de 5 reais')
            if notas2 > 0:
                if notas2 > 1:
                    print(f'{notas2} notas de 2 reais')
                else:
                    print(f'{notas2} nota de 2 reais')
            if moedas1 > 0:
                if moedas1 > 1:
                    print(f'{moedas1} moedas de 1 real')
                else:
                    print(f'{moedas1} moeda de 1 real')
            break

