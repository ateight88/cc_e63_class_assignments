import pdb
from models.coach import Coach
from models.athlete import Athlete
from models.session_plan import SessionPlan

import repositories.coach_repository as coach_repository
import repositories.athlete_repository as athlete_repository
import repositories.session_plan_repository as session_plan_repository

session_plan_repository.delete_all()
coach_repository.delete_all()
athlete_repository.delete_all()

athlete1 = Athlete('GI Jane', 3, 'Intermediate', 'Lorem ipsum dolor sit, \namet consectetur adipisicing elit. Voluptatum aliquam vitae possimus vel ex accusantium \nipsam consequatur repellat maiores tenetur quod veritatis quis dicta unde, veniam non. Eum, dolor qui.', 'https://images.unsplash.com/photo-1616877217977-fe8d019afd76?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80')
athlete_repository.save(athlete1)

athlete2 = Athlete('Ripley', 3, 'Advanced', 'Lorem ipsum dolor sit, \namet consectetur adipisicing elit. Voluptatum aliquam vitae possimus vel ex accusantium \nipsam consequatur repellat maiores tenetur quod veritatis quis dicta unde, veniam non. Eum, dolor qui.', 'https://images.unsplash.com/photo-1488228469209-c141f8bcd723?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80')
athlete_repository.save(athlete2)

athlete3 = Athlete('Dutch', 3, 'Beginner', "Lorem ipsum dolor sit, \namet consectetur adipisicing elit. Voluptatum aliquam vitae ipsam consequatur repellat maiores tenetur quod veritatis quis dicta unde, veniam non. Eum, dolor qui.", 'https://images.unsplash.com/photo-1618396394489-55f98afc580a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=928&q=80')
athlete_repository.save(athlete3)

athlete4 = Athlete('Phoenix - (No Coach)', 3, 'Beginner', "Conditional rendering to show no coach in the atlete page if not assigned to a session.", 'https://images.unsplash.com/photo-1618068656845-fa244b9f8bd4?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1548&q=80')
athlete_repository.save(athlete4)


coach1 = Coach('Arthur Lydiard', 'Running', 'https://images.squarespace-cdn.com/content/v1/5fbebf87bf71053ccb03586d/1606340765845-YD51F7SFU6705KHPWXX0/ArthurLydiardRun.jpg')
coach_repository.save(coach1)

coach2 = Coach('Arnold S.', 'Olympic Weightlifting', 'https://upload.wikimedia.org/wikipedia/commons/a/af/Arnold_Schwarzenegger_by_Gage_Skidmore_4.jpg')
coach_repository.save(coach2)

coach3 = Coach('David Marsh', 'Swimming', 'https://swimswam.com/wp-content/uploads/2016/07/David-Marsh-by-Mike-Lewis.jpg')
coach_repository.save(coach3)


session_plan1 = SessionPlan(athlete1, coach1, 'Tempo Session', "WU + 10 x 400m + CD\nDont't over strain on this workout")
saved_session_plan = session_plan_repository.save(session_plan1)
# print(saved_session_plan.session_type)
# print(session_plan1.id)

session_plan2 = SessionPlan(athlete2, coach2, 'Weights Session', "Dead Lifts: 10 x reps, 3 x sets \nWork hard but feel like you could go 2 more reps at the end of each set")
session_plan_repository.save(session_plan2)


session_plan3 = SessionPlan(athlete3, coach3, 'Intervals Session', "Front Crawl: 10 x laps, 30s rest \nWork hard but feel like you could go 2 more laps at the end of each set")
session_plan_repository.save(session_plan3)

session_plan4 = SessionPlan(athlete3, coach3, 'Long Run', "Steady Effort: 3k WU + 24k Moderate + 3k CD")
session_plan_repository.save(session_plan4)

