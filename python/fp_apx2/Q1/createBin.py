import struct

moedas = struct.Struct("20s 20s f")


def main():
    try:
        with open("conversoes.txt", "r") as arquivoTxt:
            with open("conversoes.bin", "wb") as arquivoBin:
                for linha in arquivoTxt:
                    bloco = linha.strip("\n").split("#")
                    pacote = moedas.pack(bloco[0].encode("utf-8"), bloco[1].encode("utf-8"), float(bloco[2]))
                    arquivoBin.write(pacote)
    except IOError:
        print("Um dos arquivos não foi encontrado ou você digitou errado")


main()
