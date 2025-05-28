# Subprograma pedido item a)
def checkfloat(val):
    numero = list(val)
    if numero.count(".") > 1:
        return False
    for i in range(len(numero)):
        if not numero[i].isdigit() and numero[i] != ".":
            return False
    return True


# Subprograma pedido item b)
def isfloat(entrada):
    num = list(entrada)
    if num.count(".") > 1:
        print('Há mais do que um ".".')
        exit()
    for i in range(len(num)):
        if not num[i].isdigit() and num[i] != ".":
            print(f"você digitou errado, {entrada} não é do tipo float. Na posição {i + 1} há o caracter {num[i]}.")
            exit()
    return float(entrada)


# Subprograma pedido item c)
def aplicataxa(qtd, valorusd):
    if checkfloat(str(qtd)):
        valorbrl = float(qtd) * float(valorusd)
        print(f"O valor {float(valorusd):.3f} USD com a taxa {float(qtd):.3f} vai para {float(valorbrl):.3f} BRL.")


# Subprograma pedido item d)
def aplicadesconto(precocheio):
    precodesconto = precocheio * 0.85
    return precodesconto


# Subprograma pedido item e)
def formapagamento(precobrl):
    parcelas = input("Em quantas vezes você quer comprar o produto?\n")
    if float(parcelas) == 1:
        precofinal = aplicadesconto(precobrl)
        print(f"Você ganhou 15% de desconto, portanto, de {float(precobrl):.2f} BRL você vai pagar {float(precofinal):.2f} BRL.")
    else:
        valorcomjuros = precobrl * pow(1.05, float(parcelas))
        print(f"Pagando em {parcelas} parcelas, e com 5% de juros ao mês, você pagará {float(valorcomjuros) / float(parcelas):.2f} por mês, sendo o total de {float(valorcomjuros):.2f} BRL.")


# Principal
# Como não há um roteiro, presumo que os inputs sejam dados aqui, chamando as funções

valor_usd = input("Digite o valor do produto em Dólares (USD)\n")
taxa_conversao = isfloat(str(input("Digite o valor da taxa de conversão\n")))
aplicataxa(taxa_conversao, valor_usd)
formapagamento(float(valor_usd) * float(taxa_conversao))
