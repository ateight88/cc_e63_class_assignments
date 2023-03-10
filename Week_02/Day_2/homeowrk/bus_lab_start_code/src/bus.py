class Bus:
    def __init__(self, route_number, destination):
        self.route_number = route_number
        self.destination = destination
        self.passengers = []
        
    def drive(self):
        return "Brum brum"
    
    def passenger_count(self):
        return len(self.passengers)
    
    def pick_up(self, passenger):
        self.passengers.append(passenger)
        
    def drop_off(self, passenger):
        self.passengers.remove(passenger)
        
    def empty_bus(self):
        self.passengers = []

    def pick_up_from_stop(bus, bus_stop):
        for person in bus_stop.queue:
            bus.pick_up(person)
        bus_stop.queue = []
            
        

