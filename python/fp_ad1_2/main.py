# Programa Completo AD 1-2

# Função geradora da sequência de números
def gera_sequencias(n, lista_inteiros):
    if len(lista_inteiros) == 2 * n:
        return lista_inteiros

    resultado = []

    for i in range(1, n+1):
        if numero_valido(i, lista_inteiros):
            resultado = resultado + gera_sequencias(n, lista_inteiros + [i])

    return resultado

# Função que valida a sequência de acordo com as restrições
def numero_valido(i, lista_inteiros):
    if i not in lista_inteiros:
        return True
    if lista_inteiros.count(i) > 1:
        return False

    prox_indice = 1 + i + lista_inteiros.index(i)

    if prox_indice == len(lista_inteiros):
        return True
    return False

# Função que calcula o número de sequências
def quantidade_sequencias(lista_inteiros):
    if len(lista_inteiros) == 0:
        return False

    quantidade = len(lista_inteiros) // (2 * numero)
    return quantidade

# Formatar o resultado na saída solicitada
def chunks(lst, n):
    for i in range(0, len(lst), n):
        yield lst[i:i + n]

# Principal
numero = int(input("Digite um número inteiro maior que zero\n"))

sequencias = gera_sequencias(numero, [])
qtd_sequencias = quantidade_sequencias(sequencias)
resultado_final = chunks(sequencias, numero * 2)

if len(sequencias) > 0:
    print(list(resultado_final))
    print(f'\nHá {qtd_sequencias} sequências')
else:
    print(f'\nNão há sequências possíveis com o valor {numero} de entrada.')