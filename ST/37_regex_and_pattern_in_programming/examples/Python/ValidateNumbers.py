import re
my_string = "12ab"
if re.fullmatch(r"\d+", my_string):
    print("The string contains only digits!")
else:
    print("The string does not contain only digits.")

# The Number Regex Pattern
# Integers: ^\\d+$
# Decimals: ^\\d+\\.\\d+$
# Formatted Numbers (like 1,000): ^(\\d{1,3}(,\\d{3})*|\\d+)(\\.\\d+)?$