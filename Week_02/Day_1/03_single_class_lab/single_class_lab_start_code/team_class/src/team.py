class Team:
    def __init__(self, name: str, players: list, coach: str):
        self.name = name
        self.players = players
        self.coach = coach
        self.points = 0

    def add_player(self, player_name: str):
        self.players.append(player_name)

    def has_player(self, player_name: str) -> bool:
        return player_name in self.players
    
    def play_game(self, did_win: bool):
        if did_win:
            self.points += 3
    
  
    

    