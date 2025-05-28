def formata_nome(nome_completo):
    nome = nome_completo.split()
    print(nome[0] + " " + nome[len(nome) - 1])


# Principal

n = int(input("Digite a quantidade de nomes completos que serão lidos\n"))

for i in range(n):
    nome_completo = input("Digite o nome completo\n")
    formata_nome(nome_completo)
