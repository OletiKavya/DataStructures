num1=11
num2=num1
print("address of num1 ",id(num1))
num1=15
print("num1 = ",num1)
print("num2 = ",num2)

print("address of num1 ",id(num1))
print("address of num2 ",id(num2))
print("Assigning num2 to different number :")

num2=22

print("num1 = ",num1)
print("num2 = ",num2)

print("address of num1 ",id(num1))
print("address of num2 ",id(num2))

print(" Experimenting with dictionaries   -----")

dict1={
    'value':15
}
dict2=dict1

print("dictionary 1 is :",dict1)
print("dictionary 2 is :",dict2)

print("The address of dict1 :", id(dict1))
print("The address of dict2 :", id(dict2))

print(" Assigning differnt value in dict and checking :")

dict2['value']=25

print("dictionary 1 is :",dict1)
print("dictionary 2 is :",dict2)

print("The address of dict1 :", id(dict1))
print("The address of dict2 :", id(dict2))

dict3=dict2

dict3['value']=76
print("dictionary 1 is :",dict1)
print("dictionary 2 is :",dict2)
print("dictionary 3 is :",dict3)

print("The address of dict1 :", id(dict1))
print("The address of dict2 :", id(dict2))
print("The address of dict3 :", id(dict3))
dict3={'value':65}

dict2=dict3

print("dictionary 1 is :",dict1)
print("dictionary 2 is :",dict2)
print("dictionary 3 is :",dict3)

print("The address of dict1 :", id(dict1))
print("The address of dict2 :", id(dict2))
print("The address of dict3 :", id(dict3))
