users = {
  "Jonathan": {
    "twitter": "jonnyt",
    "lottery_numbers": [6, 12, 49, 33, 45, 20],
    "home_town": "Stirling",
    "pets": [
    {
      "name": "fluffy",
      "species": "cat"
    },
    {
      "name": "fido",
      "species": "dog"
    },
    {
      "name": "spike",
      "species": "dog"
    }
  ]
  },
  "Erik": {
    "twitter": "eriksf",
    "lottery_numbers": [18, 34, 8, 11, 24],
    "home_town": "Linlithgow",
    "pets": [
    {
      "name": "nemo",
      "species": "fish"
    },
    {
      "name": "kevin",
      "species": "fish"
    },
    {
      "name": "spike",
      "species": "dog"
    },
    {
      "name": "rupert",
      "species": "parrot"
    }
  ]
  },
  "Avril": {
    "twitter": "bridgpally",
    "lottery_numbers": [12, 14, 33, 38, 9, 25],
    "home_town": "Dunbar",
    "pets": [
      {
        "name": "monty",
        "species": "snake"
      }
    ]
  }
}

# 1. Get Jonathan's Twitter handle (i.e. the string `"jonnyt"`)
print(f'1: Jonathan\'s Twitter handle: {users["Jonathan"]["twitter"]}\n')

# 2. Get Erik's hometown
print(f'2: Erik\'s hometown: {users["Erik"]["home_town"]}\n')

# 3. Get the list of Erik's lottery numbers
print(f'3: list of Erik\'s lottery numbers: {users["Erik"]["lottery_numbers"]}\n')

# 4. Get the species of Avril's pet Monty
print(f'4: the species of Avril\'s pet Monty: {users["Avril"]["pets"][0]["species"]}\n')

# 5. Get the smallest of Erik's lottery numbers
eriks_lotto_numbers = users["Erik"]["lottery_numbers"]
smallest_num = min(eriks_lotto_numbers)
print(f'5: the smallest of Erik\'s lottery numbers: {smallest_num}\n')

# 6. Return an list of Avril's lottery numbers that are even
avrils_lotto_nums = users["Avril"]["lottery_numbers"]
avrils_even_lotto_nums = [num for num in avrils_lotto_nums if num % 2 == 0]
print(f'6: Avril\'s even lottery numbers: {avrils_even_lotto_nums}\n')

# 7. Erik is one lottery number short! Add the number `7` to be included in his lottery numbers
eriks_lotto_nums = users["Erik"]["lottery_numbers"] 
eriks_lotto_nums.append(7)
print(f'7: Adding 7 to  Erik\'s lottery numbers: {eriks_lotto_nums}\n')

# 8. Change Erik's hometown to Edinburgh
users["Erik"]["hometown"] = "Edinburgh"
print(f'8: Change  Erik\'s hometown: {users["Erik"]["hometown"]}\n')

# 9. Add a pet dog to Erik called "fluffy"
eriks_pets = users["Erik"]["pets"]
new_pet = {"name": "fluffy", "species": "dog"}
eriks_pets.append(new_pet)
print(f'9: Add a pet dog to  Erik\'s pets: {users["Erik"]["pets"]}\n')

# 10. Add another person to the users dictionary
users["Tony"] = {
    "twitter": "tony_d",
    "lottery_numbers": [7, 11, 22, 33, 44, 49],
    "home_town": "Dublin",
    "pets": [
        {"name": "tigger", "species": "cat"},
        {"name": "toby", "species": "dog"},
        {"name": "toto", "species": "budgie"}
    ],
}
print(f'10: Add another person: {users["Tony"]}\n')
