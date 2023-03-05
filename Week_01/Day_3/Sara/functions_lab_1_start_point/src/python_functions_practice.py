def return_10():
    return 10

def add(num1, num2):
    return num1 + num2

def subtract(num1, num2):
    return num1 - num2

def multiply(num1, num2):
    return num1 * num2

def divide(num1, num2):
    return num1 / num2

def length_of_string(str):
    return(len(str))

def join_string( str_1, str_2 ):
        return str_1 + str_2

def add_string_as_number(str_1, str_2 ):
    return int(str_1) + int(str_2)

# test_number_to_full_name__month_1
def number_to_full_month_name(month_1):
    months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
    month_1 = 1
    return months[month_1 -1]   

# test_number_to_full_name__month_3
def number_to_full_month_name(month_3):
    months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
    month_3 = 3
    return months[month_3 -1]

# test_number_to_full_name__month_9
def number_to_full_month_name(month_9):
    months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"]
    month_9 = 9
    return months[month_9 -1]

# test_number_to_short_month_name__month_1
def number_to_short_month_name(month_1):
    short_month_names = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    month_1 = 1
    return short_month_names[month_1-1]

# test_number_to_short_month_name__month_4
def number_to_short_month_name(month_4):
    short_month_names = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    month_4 = 4
    return short_month_names[month_4-1]

# test_number_to_short_month_name__month_10
def number_to_short_month_name(month_10):
    short_month_names = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"]
    month_10 = 10
    return short_month_names[month_10-1]





