# Subprograma

def abreArquivo(arquivo):
    file = open(arquivo + ".txt", "r")
    if not file.readline():
        print("Não existem menor, maior, média e desvio, pois o arquivo está vazio!!!")
        file.close()
    else:
        file.seek(0)
        print(f"Conteúdo do Arquivo {arquivo}:")
        menor = maior = soma = n = somatorio = 0

        for linha in file:
            print(linha.strip())
            num = list(map(int, linha.split()))
            n += len(num)
            for i in num:
                if i > maior:
                    maior = i
                elif i < menor:
                    menor = i
                soma += i

        media = soma / n
        file.seek(0)

        for line in file:
            num2 = list(map(int, line.split()))
            for j in num2:
                somatorio += (j - media) ** 2

        desv = (somatorio / n) ** 0.5

        print(f"\nMenor Valor em {arquivo}: {menor}")
        print(f"Maior Valor em {arquivo}: {maior}")
        print(f"Média dos Valores em {arquivo}: {media:.2f}")
        print(f"Desvio Padrão em {arquivo}: {desv:.2f}")
        file.close()


# Principal
arquivo = input("Digite o nome do arquivo de texto a ser lido, sem a extensão\n")
abreArquivo(arquivo)
