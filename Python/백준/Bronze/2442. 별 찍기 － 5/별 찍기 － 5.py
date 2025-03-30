inputStr = int(input())
index = int(inputStr)

for i in range(1, index * 2, 2) :
    star = "";
    for j in range(0, i, 1) :
        star += "*"


    result = "{:>" + str(inputStr) + "}"
    print(result.format(star))
    inputStr += 1