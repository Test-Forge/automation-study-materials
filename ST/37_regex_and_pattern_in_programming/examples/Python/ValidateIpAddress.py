import re
def validate_ip_regex(ip_address):
    match = re.match(
        r"[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}", "127.0.0.1", ip_address)

    if not bool(match):
        print(f"The IP address {ip_address} is not valid")
        return False

    bytes = ip_address.split(".")

    for ip_byte in bytes:
        if int(ip_byte) < 0 or int(ip_byte) > 255:
            print(f"The IP address {ip_address} is not valid")
            return False
    print(f"The IP address {ip_address} is valid")
    return True