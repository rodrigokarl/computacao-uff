import os


def ehprimo(n):
    if n > 1:
        for i in range(2, n):
            if n % i == 0:
                return False
        return True
    else:
        return False


def mostrar(arquivo, n):
    try:
        if n == 0:
            print(f"\nConteúdo do Arquivo {arquivo}:")
        if n == 1:
            print(f"\nConteúdo do Arquivo {arquivo} após eventuais remoções:")
        with open(arquivo, "r") as arq:
            for linha in arq:
                print(linha.strip("\n"))
    except IOError:
        print("Arquivo não encontrado")


def processa(arquivo):
    try:
        with open(arquivo, "r") as arq1:
            with open("tmp.txt", "w") as arq2:
                for linha in arq1:
                    line = map(int, linha.split())
                    flag = 0
                    for i in line:
                        if ehprimo(i):
                            flag += 1
                    if flag == 0:
                        arq2.write(linha)
        with open("tmp.txt", "r") as arqtmp:
            with open(arquivo, "w") as arqfinal:
                for linha in arqtmp:
                    arqfinal.write(linha)
        os.remove("tmp.txt")

    except IOError:
        print("Arquivo não encontrado")


file = input("Digite o nome do arquivo com extensão.\n")

mostrar(file, 0)

processa(file)

mostrar(file, 1)
