# For the following list of numbers:

numbers = [1, 6, 2, 2, 7, 1, 6, 13, 99, 7]

# 1. Print out a list of the even integers:
even_numbers = [num for num in numbers if num % 2 == 0]
print(f'1: Print even numbers: {even_numbers}\n')

# 2. Print the difference between the largest and smallest value:
max = max(numbers)
min = min(numbers)

diff = max - min
print(f'2: Diff between max & min: {diff}\n')

# 3. Print True if the list contains a 2 next to a 2 somewhere.
# check = [1, 6, 2, 2, 7, 1, 6, 13, 99, 7]

for i in range(len(numbers)-1):
    if numbers[i] == 2 and numbers[i+1] == 2:
        print(f'3: Print True if 2 is beside a 2: {True}\n')
        break
else:
    print(False)


# 4. Print the sum of the numbers, 
#    BUT ignore any section of numbers starting with a 6 and extending to the next 7.
#    
#    So [11, 6, 4, 99, 7, 11] would have sum of 22

# ignore = False
# total = 0

# for num in numbers:
#     print(f'before if == 6: {num}')
#     if num == 6:
#       print(f'after if == 6: {num}')
#       ignore = True
#     if num == 2:
#         print(f'before if == 2: {num}')
#         ignore = True
#         print(f'after if == 2: {num}')
#     elif num == 7:
#         print(f'before if == 3: {num}')
#         ignore = True
#         print(f'after if == 3: {num}')
#     elif not ignore:
#         total += num

# print(total)


# 5. HARD! Print the sum of the numbers. 
#    Except the number 13 is very unlucky, so it does not count.
#    And numbers that come immediately after a 13 also do not count.
#    HINT - You will need to track the index throughout the loop.
#
#    So [5, 13, 2] would have sum of 5. 

# ignore_next = False
# total = 0

# for num in numbers:
#     print(f'before if: {num}')
#     if num == 13:
#         ignore_next = True # 19
#         print(f'after if: {num}')        
#     elif ignore_next:
#           print(f'after elif: {num}')        
#           ignore_next = True
#           print(f'after ignore_next: {num}')        
#         # print(num)
#     else:
#         total += num

# print(total)







