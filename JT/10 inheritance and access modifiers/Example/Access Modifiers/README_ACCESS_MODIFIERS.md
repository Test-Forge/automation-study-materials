# Access Modifiers
***

## Contents
- [Basic idea](#basic-idea)
- [Private access modifiers](#private-access-modifiers)
- [Default access modifiers](#default-access-modifiers)
- [Protected access modifiers](#protected-access-modifiers)
- [Public access modifiers](#public-access-modifiers)
- [Resources](#resources)


## Basic idea
***
The _**access modifiers**_ in Java specifies the accessibility or scope of a field, method, constructor or class. We can change the access level of fields, constructors, methods, and class by 
applying the access modifier on it.
There are **four types** of Java access modifiers:
        - _Private_
        - _Default_
        - _Protected_
        - _Public_

![Access Modifiers](https://raw.githubusercontent.com/bodacd/automation-study-materials/7b5aad9f185b4a8801381b60aa528778486f41e0/JT/10%20inheritance%20and%20access%20modifiers/resources/Access%20Modifiers/Access_Modifiers.png)
## Private access modifiers

The access level of a private modifier is only within the class. It cannot be accessed from outside the class.

_Sample Code_
**Private_Access_Modifier.java**: is an example demonstrating the role of private access modifiers for data member, method and constructor.


## Default access modifiers

If you don't use any modifier, it is treated as default by default. The default modifier is accessible only within package. It cannot be accessed from outside the package. It provides more
accessibility than private. But, it is more restrictive than protected and public.

_Sample Code_
**Default_Access_Modifier.java**: is an example demonstrating the role of default access modifiers for class and method.


## Protected access modifiers

The protected access modifier is accessible within package and outside the package but through inheritance only.

The protected access modifier can be applied on the data member, method and constructor. It can't be applied on the class.

It provides more accessibility than the default modifer.

_Sample Code_
**Protected_Access_Modifier.java**: is an example demonstrating the role of protected access modifiers for class and method.


## Public access modifiers

The public access modifier is accessible everywhere. It has the widest scope among all other modifiers.

_Sample Code_
**Public_Access_Modifier.java**: is an example demonstrating the role of public access modifiers for class and method.


## Resources
***
- [Access Modifiers in Java](https://www.javatpoint.com/access-modifiers)
