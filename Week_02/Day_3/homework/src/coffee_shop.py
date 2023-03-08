class CoffeeShop:
  def __init__(self, name, till, drinks, foods, stock):
    self.name = name
    self.till = till
    self.drinks = drinks
    self.foods = foods
    self.stock = stock

  def increase_till(self, amount):
    self.till += amount

  def find_drink(self, drink_name):
    for drink in self.drinks:
        if drink.name == drink_name:
            return drink
    return None  

  def find_food(self, food_name):
    for food in self.foods:
        if food.name == food_name:
            return food
    return None  
  

  def serve_customer(self, customer):
        if customer.age > 16:
            return True
        else:
            return False      

  def sell_drink(self, drink_name, customer):
        drink = self.find_drink(drink_name)
        if drink and customer.wallet >= drink.price:
            customer.buy_drink(drink)
            self.till += drink.price
            return True
        else:
            return False