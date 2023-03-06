class Student:
    def __init__(self, name: str, cohort: str):
        self.name = name
        self.cohort = cohort

    def talk(self) -> str:
        return "I can talk!"

    def say_favourite_language(self, language: str) -> str:
        return f"I love {language}"

Alice = Student('Alice', 'E41')
print(Alice.name)

print(Alice.talk())

print(Alice.say_favourite_language('running'))





