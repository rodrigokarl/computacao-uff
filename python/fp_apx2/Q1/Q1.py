import struct

moedas = struct.Struct("20s 20s f")

siglas = {"euro": "EUR", "dolar": "USD", "real": "BRL"}


def ehfloat(n):
    try:
        float(n)
        return True
    except ValueError:
        return False


def decode(bloco):
    pacote = moedas.unpack(bloco)
    return pacote[0].decode("utf-8").rstrip(chr(0)), pacote[1].decode("utf-8").rstrip(chr(0)), pacote[2]


def processa(arquivo, moeda1, moeda2, valor):
    try:
        with open(arquivo, "rb") as arquivoBin:
            dados = dict()
            while True:
                bloco = arquivoBin.read(moedas.size)
                if not bloco:
                    break
                a, b, c = decode(bloco)
                dados[a + "_" + b] = c
            if moeda1 not in siglas.keys() or moeda2 not in siglas.keys():
                print("Alguma moeda não consta")
                exit()
            if moeda1 == "dolar":
                if moeda2 == "real":
                    valorfinal = valor * dados["dolar_real"]
                else:
                    valorfinal = valor / dados["euro_dolar"]
            if moeda1 == "euro":
                if moeda2 == "real":
                    valorfinal = valor * dados["euro_real"]
                else:
                    valorfinal = valor * dados["euro_dolar"]
            if moeda1 == "real":
                if moeda2 == "dolar":
                    valorfinal = valor / dados["dolar_real"]
                else:
                    valorfinal = valor / dados["euro_real"]
            print(f"Você pagará {valorfinal:.2f} {siglas[moeda2]} por {valor:.2f} {siglas[moeda1]}.")
            # coloquei os 2 valores com 2 casas decimais a fim de padronizacao
            # para o caso de a entrada da moeda 2 ser float
    except IOError:
        print("Um dos arquivos não foi encontrado ou você digitou errado")


# principal

file = input("Digite o nome do arquivo com extensão\n")
m1 = input("Digite o nome da moeda 1\n")
m2 = input("Digite o nome da moeda 2\n")
value = input("Digite o valor a ser convertido\n")

if ehfloat(value):
    processa(file, m1, m2, float(value))
else:
    print("Você colocou um valor não correspondente")
