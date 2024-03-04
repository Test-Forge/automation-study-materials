import re

numbers = ["+18009592809", "=18009592809"]

for number in numbers:
    if not re.match(re.compile(r"^(\+1?[-. ]?(\d+))$"), number):
        print("Number is not valid")
    else:
        print("Number is valid")