import re

regex = re.compile(r'([A-Za-z0-9]+[.-_])*[A-Za-z0-9]+@[A-Za-z0-9-]+(\.[A-Z|a-z]{2,})+')
def isValid(email):
    if re.fullmatch(regex, email):
        print("Valid email")
    else:
        print("Invalid email")

 # Validate phone number
validate_phone_number_pattern = "^\\+?[1-9][0-9]{7,14}$"
re.match(validate_phone_number_pattern, "+12223334444") # Returns Match object

# Extract phone number from a string
extract_phone_number_pattern = "\\+?[1-9][0-9]{7,14}"
re.findall(extract_phone_number_pattern, 'You can reach me out at +12223334444 and +56667778888') # returns ['+12223334444', '+56667778888']