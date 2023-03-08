class Customer:
    # pass
    def __init__(self, name, age, wallet, energy_level):
        # pass
        self.name = name
        self.age = age
        self.wallet = wallet
        self.energy_level = energy_level

    def buy_drink(self, drink):
        self.wallet -= drink.price
        self.energy_level += drink.caffeine_level

    def buy_food(self, food):
         self.wallet -= food.price 
         self.energy_level -= food.rejuv_lvl

