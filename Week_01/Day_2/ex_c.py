united_kingdom = [
  {
    "name": "Scotland",
    "population": 5295000,
    "capital": "Edinburgh"
  },
  {
    "name": "Wales",
    "population": 3063000,
    "capital": "Swansea"
  },
  {
    "name": "England",
    "population": 53010000,
    "capital": "London"
  }
]

# 1. Change the capital of Wales from `"Swansea"` to `"Cardiff"`.
Wales = united_kingdom[1]
Wales["capital"] = "Cardiff"
print(f'1: Change the capital of Wales: {united_kingdom[1]["capital"]}\n')

# 2. Create a dictionary for Northern Ireland and add it to the `united_kingdom` list (The capital is Belfast, and the population is 1,811,000).
northern_ireland = {
    "name": "Northern Ireland", 
    "population": 1811000, 
    "capital": "Belfast"
    }
united_kingdom.append(northern_ireland)
print(f'2: Create a dictionary for Northern Ireland and add to the UK: {united_kingdom}\n')

# 3. Use a loop to print the names of all the countries in the UK.

print(f'3: Print countries in the UK:\n')
for countries in united_kingdom:
    print(countries["name"])

# 4. Use a loop to find the total population of the UK.
total_population = 0

for country in united_kingdom:
    total_population += country["population"]

print(f'\n3: Total population in the UK: {total_population}\n')