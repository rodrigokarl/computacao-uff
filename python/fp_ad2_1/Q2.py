# Subprograma

def mostrar(nomearquivo, n):
    file = open(nomearquivo + ".txt", "r")
    if n == 0:
        print(f"Conteúdo do Arquivo {nomearquivo}:")
    if n == 1:
        print(f"Conteúdo do Arquivo {nomearquivo} após eventuais remoções:")
    for linha in file:
        print(linha.strip())
    file.close()


def processamento(nome1, nome2):
    ptsaremover = []

    def distancia(xA, yA, xB, yB):
        return ((xA - xB) ** 2 + (yA - yB) ** 2) ** 0.5


    def circ(nome2, xL, yL):
        file2 = open(nome2 + ".txt", "r")
        for linha2 in file2:
            xC, yC, r = map(float, linha2.split())
            if distancia(xL, xC, yL, yC) < r:
                if xL not in ptsaremover:
                    ptsaremover.append(xL)
                if yL not in ptsaremover:
                    ptsaremover.append(yL)
        file2.close()
        return ptsaremover


    def pontos(nome1):
        file1 = open(nome1 + ".txt", "r")
        for linha1 in file1:
            xL, yL = map(float, linha1.split())
            circ(nome2, xL, yL)
        file1.close()

        file1 = open(nome1 + ".txt", "r")
        file3 = open("tmp.txt", "w")
        for linha1 in file1:
            a, b = map(float, linha1.split())
            if a and b not in ptsaremover:
                file3.write(linha1)
        file1.close()
        file3.close()

    def escreve(nome1):
        file3 = open("tmp.txt", "r")
        file1 = open(nome1 + ".txt", "w")
        for linha3 in file3:
            file1.write(linha3)
        file3.close()
        file1.close()


    pontos(nome1)
    escreve(nome1)


# Principal
arquivo1 = input("Digite o nome do primeiro arquivo, sem extensão\n")
arquivo2 = input("Digite o nome do segundo arquivo, sem extensão\n")
mostrar(arquivo1, 0)
mostrar(arquivo2, 0)
processamento(arquivo1, arquivo2)
mostrar(arquivo1, 1)
