# WRITE YOUR FUNCTIONS HERE

def get_pet_shop_name(pet_shop):
    return pet_shop["name"]

def get_total_cash(pet_shop):
    return pet_shop["admin"]["total_cash"]

def add_or_remove_cash(pet_shop, amount):
     pet_shop["admin"]["total_cash"] += amount

# def add_or_remove_cash(pet_shop, amount):
#      pet_shop["admin"]["total_cash"] -= amount

def get_pets_sold(pet_shop):
     return pet_shop["admin"]["pets_sold"]

def increase_pets_sold(pet_shop, sold):
      pet_shop["admin"]["pets_sold"] += sold

def get_stock_count(pet_shop):
      return len(pet_shop["pets"])

def get_pets_by_breed(pet_shop, breed):
    matching_pets = []
    for pet in pet_shop["pets"]:
            if pet["breed"] == breed:
                matching_pets.append(pet)
    return matching_pets

# def get_pets_by_breed(pet_shop, breed):
#     matching_pets = []
#     for pet in pet_shop["pets"]:
#         if pet["breed"] == breed:
#             matching_pets.append(pet)
#     return matching_pets


def find_pet_by_name(pet_shop, name):
     for pet in pet_shop["pets"]:
          if pet["name"] == name:
            return pet
     
     return None

def find_pet_by_name(pet_shop, name):
     for pet in pet_shop["pets"]:
          if pet["name"] == name:
            return pet
     
     return None

def remove_pet_by_name(pet_shop, name):
     for pet in pet_shop["pets"]:
          if pet["name"] == name:
            pet_shop["pets"].remove(pet)

def add_pet_to_stock(pet_shop, new_pet):
     return pet_shop["pets"].append(new_pet)    

def get_customer_cash(customer):
          return customer["cash"]

def remove_customer_cash(customers, amt):
          customers["cash"] -= amt

def get_customer_pet_count(customers):
          return len(customers["pets"])

def add_pet_to_customer(customers, new_pet):
          return customers["pets"].append(new_pet)
          
def  customer_can_afford_pet(customer, pet):
     return customer["cash"] >= pet["price"]

def  customer_can_afford_pet(customer, pet):
     return customer["cash"] >= pet["price"]
           
def  customer_can_afford_pet(customer, pet):
     return customer["cash"] >= pet["price"]



                 
     
     




          