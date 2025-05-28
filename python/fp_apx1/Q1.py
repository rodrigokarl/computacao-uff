def processa_numeros(n):
    n = n.split()
    n = sorted(n, key=float)
    print(f"Menor: {n[0]} Maior: {n[len(n) -1]}")


# Principal
temp = []
while True:
    n = input("Digite um ou mais números inteiros ou de ponto flutuante, separados por espaço\n")
    temp += map(float, n.split())
    if n == "" or n == " ":
        if len(temp) < 1:
            print("Nenhum Número Foi Lido. Portanto, não existe média!!!")
            break
        else:
            print(f"Quantidade de números lidos {len(temp)}")
            print(f"Média dos Números Lidos: {sum(temp) / len(temp):.2f}")
            break
    processa_numeros(n)
