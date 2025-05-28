def palindromo(palavra):
    if palavra == "":
        return palavra
    else:
        return palindromo(palavra[1:]) + palavra[0]


arq = open(input("Digite o nome do arquivo de texto\n"), "r")

for i in arq:
    pal = i.split()
    for j in range(len(pal)):
        temp = pal[j]
        if temp == palindromo(pal[j]):
            print(pal[j])

arq.close()
