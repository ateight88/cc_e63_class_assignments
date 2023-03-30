class SessionPlan:

    def __init__( self, user, coach, session_type,guidance, id=None ):
        self.user = user
        self.coach = coach
        self.session_type = session_type
        self.guidance = guidance
        self.id = id
