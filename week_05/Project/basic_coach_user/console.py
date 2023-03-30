import pdb
from models.coach import Coach
from models.user import User
from models.session_plan import SessionPlan

import repositories.coach_repository as coach_repository
import repositories.user_repository as user_repository
import repositories.session_plan_repository as session_plan_repository

session_plan_repository.delete_all()
coach_repository.delete_all()
user_repository.delete_all()

user1 = User('GI Jane', 3, 'Intermediate', 'Lorem ipsum dolor sit, \namet consectetur adipisicing elit. Voluptatum aliquam vitae possimus vel ex accusantium \nipsam consequatur repellat maiores tenetur quod veritatis quis dicta unde, veniam non. Eum, dolor qui.')
user_repository.save(user1)

user2 = User('Ripley', 3, 'Advanced', 'Lorem ipsum dolor sit, \namet consectetur adipisicing elit. Voluptatum aliquam vitae possimus vel ex accusantium \nipsam consequatur repellat maiores tenetur quod veritatis quis dicta unde, veniam non. Eum, dolor qui.')
user_repository.save(user2)

user3 = User('Dutch', 3, 'Beginner', ("Lorem ipsum dolor sit, \n"
                                      "amet consectetur adipisicing elit. Voluptatum aliquam vitae possimus vel ex accusantium \n"
                                      "ipsam consequatur repellat maiores tenetur quod veritatis quis dicta unde, veniam non. Eum, dolor qui."))
user_repository.save(user3)


coach1 = Coach('Arthur Lydiard', 'Running', 'https://lh3.googleusercontent.com/wGv-V36kmVeY6327GMOFSTlQyQVfCmkDcyy1_3b1fpPcuAX24lfhPacq-dOSGVfMjoba8UJ2w53QYpTd-S1m6nYKzJFswRJ942btZMnlsp5_74Aj=w1280')
coach_repository.save(coach1)

coach2 = Coach('Arnold S.', 'Oplympic Weightlifting', 'https://upload.wikimedia.org/wikipedia/commons/a/af/Arnold_Schwarzenegger_by_Gage_Skidmore_4.jpg')
coach_repository.save(coach2)

coach2 = Coach('David Marsh', 'Swimming', 'https://swimswam.com/wp-content/uploads/2016/07/David-Marsh-by-Mike-Lewis.jpg')
coach_repository.save(coach2)


session_plan1 = SessionPlan(user1, coach1, 'Tempo Session -', "WU + 10 x 400m + CD\nDont't over strain on this workout")
saved_session_plan = session_plan_repository.save(session_plan1)
print(saved_session_plan.session_type)
print(session_plan1.id)

session_plan2 = SessionPlan(user2, coach2, 'Weights Session -', "Dead Lifts: 10 x reps, 3 x sets \nWork hard but feel like you could go 2 more reps at the end of each set")
session_plan_repository.save(session_plan2)

# session_plan2 = SessionPlan(user3, coach1, 'Do this session at a comfortably hard effort')
# session_plan_repository.save(session_plan2)

# session_plan3 = SessionPlan(user1, coach2, 'You should be at a 9/10 effort for the on sections')
# session_plan_repository.save(session_plan3)

# session_plan4 = SessionPlan(user2, coach2, 'Steady strong effort for the whole session')
# session_plan_repository.save(session_plan4)

# loc = session_plan_repository.coach(session_plan4)

# pdb.set_trace()
