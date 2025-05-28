def busca(arquivo, palavra):
    try:
        with open(arquivo, "r") as arquivoTxt:
            count = 0
            for linha in arquivoTxt:
                count += 1
                line = linha.strip("\n,.").split()
                if palavra in line:
                    print(f"Linha {count}, Palavra {line.index(palavra) + 1} nesta linha!")

    except IOError:
        print(f"Arquivo {arquivo} não encontrado")


# principal
file = input("Digite o nome do arquivo, com extensão\n")
word = input("Digite a palavra a ser procurada\n")
busca(file, word)
