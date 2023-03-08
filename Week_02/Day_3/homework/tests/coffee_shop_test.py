import unittest
from src.coffee_shop import CoffeeShop
from src.drink import Drink
from src.food import Food
from src.customer import Customer

class TestCoffeeShop(unittest.TestCase):
    # pass
    def setUp(self):

        self.coffee_shop = CoffeeShop("Nero's", 500.00, "Latte", "Sandwich", 5)


    #  @unittest.skip("Skip test")
    def test_coffee_shop_has_name(self): 
        self.assertEqual("Nero's", self.coffee_shop.name) 

    # @unittest.skip("Skip test")
    def test_coffee_shop_has_drink(self): 
        self.assertEqual("Latte", self.coffee_shop.drinks) 

    # @unittest.skip("Skip test")
    def test_coffee_shop_has_food(self): 
        self.assertEqual("Sandwich", self.coffee_shop.foods) 


    # @unittest.skip("Skip test")
    def test_increase_till(self):
        self.coffee_shop.increase_till(3.50)
        expected = 503.50
        actual = self.coffee_shop.till
        self.assertEqual(expected, actual)

    # @unittest.skip("Skip test")
    def test_serve_customer(self):
        # Test that a customer can be served if they are of legal age
        coffee_shop = CoffeeShop("Starbucks", 100, {}, {}, 5)
        customer_legal = Customer("John", 17, 50, 5)
        self.assertTrue(coffee_shop.serve_customer(customer_legal))

        # Test that a customer cannot be served if they are underage
        customer_underage = Customer("Jane", 5, 20, 9)
        self.assertFalse(coffee_shop.serve_customer(customer_underage))

    # @unittest.skip("Skip test")
    def test_sell_drink_success(self):
        drinks = [Drink("Mocha", 4, 5), Drink("Latte", 3, 4), Drink("Hot Chocolate", 3.5, 0), Drink("Tea", 2, 3)]
        foods = {}
        stock = 10
        coffee_shop = CoffeeShop("Starbucks", 100, drinks, foods, stock)
        customer = Customer("John", 17, 50, 8)
        result = coffee_shop.sell_drink("Mocha", customer)
        self.assertTrue(result) # check if the result is True
        self.assertEqual(customer.wallet, 46) # check if the customer's wallet was reduced
        self.assertEqual(coffee_shop.till, 104) # check if the coffee shop's till was increased

    # @unittest.skip("Skip test")
    def test_customer_energy_level_increase(self):
        drink = Drink("Mocha", 4, 9)
        customer = Customer("John", 30, 10, 10)
        customer.buy_drink(drink)
        self.assertEqual(customer.wallet, 6)
        self.assertEqual(customer.energy_level, 19)
    
    # @unittest.skip("Skip test")
    def test_customer_energy_level_increase(self):
        food = Food("Sandwich", 4, 2)
        customer = Customer("John", 30, 20, 10)
        customer.buy_food(food)
        self.assertEqual(customer.wallet, 16)
        self.assertEqual(customer.energy_level, 8)