import struct


bandeiras = struct.Struct("20s 50s")


def main():
    try:
        with open("cartoes.txt", "r") as arquivotxt:
            with open("cartoes.bin", "wb") as arquivobin:
                for linha in arquivotxt:
                    bloco = linha.split("#")
                    pacote = bandeiras.pack(bloco[0].encode("utf-8"), bloco[1].encode("utf-8"))
                    arquivobin.write(pacote)
    except IOError:
        print("Um dos arquivos não foi encontrado ou você digitou errado")


main()
