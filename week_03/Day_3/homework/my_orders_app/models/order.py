class Order():

    def __init__(self, customer_name, order_date, book, price, qty, delivered):
        # self.order_id = order_id
        self.customer_name = customer_name
        self.order_date = order_date
        self.book = book
        self.price = price
        self.qty = qty
        self.delivered = delivered
