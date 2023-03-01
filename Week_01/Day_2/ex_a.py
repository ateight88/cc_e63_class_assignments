stops = [ "Croy", "Cumbernauld", "Falkirk High", "Linlithgow", "Livingston", "Haymarket" ]


#1. Add "Edinburgh Waverley" to the end of the list
stops[-1] = "Edinburgh Waverley"
print(f'1: Add to end: {stops}\n')


#2. Add "Glasgow Queen St" to the start of the list
stops[0] = "Glasgow Queen St"
print(f'2: Add to start: {stops}\n')


#3. Add "Polmont" at the appropriate point (between "Falkirk High" and "Linlithgow")
stops.insert(3, "Polmont") 
print(f'3: Add between "Falkirk High" and "Linlithgow": {stops}\n')


#4. Print out the index position of "Linlithgow"
print(f'4: index position of Linlithgow": {stops.index("Linlithgow")}\n')


#5. Remove "Livingston" from the list using its name
stops.remove("Livingston") 
print(f'5: Remove "Livingston": {stops}\n')


#6. Delete "Cumbernauld" from the list by index
stops.pop(1)
print(f'6: Delete "Cumbernauld"": {stops}\n')


#7. Print the number of stops there are in the list
print(f'7: Print the number of stops: {len(stops)}\n')


#8. Sort the list alphabetically
print(f'8: Sort the list alphabetically: {sorted(stops)}\n')


#9. Reverse the positions of the stops in the list
print(f'9: Reverse the positions of the stops: {stops.reverse()}\n')


#10 Print out all the stops using a for loop
for stop in stops:
    print(stop)
