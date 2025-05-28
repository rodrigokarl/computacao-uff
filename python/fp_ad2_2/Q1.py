import struct

# cria o Struct no formato pedido
bandeiras = struct.Struct("20s 50s")


# decodifica o bloco solicitado
def decode(bloco):
    pacote = bandeiras.unpack(bloco)
    nomebandeira = pacote[0].decode("utf-8").strip(chr(0))
    taxabandeira = pacote[1].decode("utf-8").strip(chr(0))
    return nomebandeira, taxabandeira


# processamento principal dos dados
def processamento(arquivo, bandeira, taxa, preco):
    try:
        with open(arquivo, "rb") as arquivobin:
            dados = {}
            while True:
                bloco = arquivobin.read(bandeiras.size)
                if not bloco:
                    break
                nomebandeira, taxabandeira = decode(bloco)
                dados[nomebandeira] = float(taxabandeira.strip("\n"))
            if bandeira not in dados:
                print("Cartão não consta")
                exit()
            total = (preco * taxa) + dados[bandeira]
            print(f"Como seu cartão é da bandeira {bandeira}, então você pagará {total:.2f}.")

    except IOError:
        print("Um dos arquivos não foi encontrado ou você digitou errado")


# principal

file = input("Digite o nome do arquivo com a extensão\n")
card = input("Digite a bandeira do cartão\n")
try:
    tax = float(input("Digite a taxa de conversão da moeda\n"))
except ValueError:
    print("Você colocou uma taxa não correspondente")
    exit()
try:
    price = float(input("Digite o preço do produto a ser convertido\n"))
except ValueError:
    print("Você colocou um valor não correspondente")
    exit()
processamento(file, card, tax, price)
