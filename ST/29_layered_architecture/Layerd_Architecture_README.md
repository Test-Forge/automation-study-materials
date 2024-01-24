# Layered (N-tier) architecture
***

## Contents
- [Basic idea](#basic-idea)
- [Benefits/drawbacks](#benefitsdrawbacks)
- [Typical layers](#typical-layers)
- [Open/closed layers](#openclosed-layers)
- [Typical antipattern: lasagna architecture](#typical-antipattern-lasagna-architecture)
- [Resources](#resources)

## Basic idea
***
The most common architecture pattern is the layered architecture pattern, otherwise known as the n-tier architecture pattern. 
This pattern is the de facto standard for most Java EE applications and therefore is widely known by most architects, designers, and developers. 

Components within the layered architecture pattern are organized into horizontal layers, each layer performing a
specific role within the application. Request passes through layers from top to bottom and then back up,
and each layer can depend on one or a few layers below it but should not know anything about any layer above it
<p align="center" width="100%">
    <img width="60%" src=resources/layered_architecture.png> 
</p>

## Benefits/drawbacks
***
**Advantages:**
- Secure: You can secure each of the three tiers separately using different methods.
- Easy to manage: You can manage each tier separately, adding or modifying each tier without affecting the other tiers.
- Scalable: If you need to add more resources, you can do it per tier, without affecting the other tiers.
- Flexible: Apart from isolated scalability, you can also expand each tier in any manner that your requirements dictate.

**Disadvantages:**
- Layers make an application more difficult to maintain. Each change requires analysis.
- Layers may affect application performance because they create overhead in execution: each layer in the upper levels
  must connect to those in the lower levels for each operation in the system.

## Typical layers
***
> ⚠️ **Rule-of-thumb:**
>
> Use just the layers you need and nothing more !

- **Presentation layer:** contains code related to interaction with the user
    - APIs are exposed here
    - Server-side rendering would also sit here
- **Business layer:** contains business logic to work with entities
    - If persistence layer returns data transfer objects without actual behavior, all business logic will sit here
    - If persistence layer returns instances of classes encapsulating business logic, the business layer will call
      methods on those instances as needed and coordinate across multiple instances of potentially multiple classes as
      needed
- **Persistence layer:** takes care of talking to the database
    - Provides interfaces for retrieving and saving data (getUser(id: string), saveUser(user: User))
    - Could return simple data transfer objects or instances of business entity classes that actually encapsulate
      business logic
        - Try to return something that makes sense from the point of view of the domain, rather than just the structure
          of database rows (this way, all stuff specific to the kind of database we use is encapsulated in this layer
          and also easy to change)
- **Database layer:** the actual database

> ❗**NOTE:**
>
> A layered architecture could have more layers than these if it makes sense

## Open/closed layers
***
An N-tier application can have a closed layer architecture or an open layer architecture:

- In a closed layer architecture, a layer can only call the next layer immediately down.
    - Can be important for security, data integrity
- In an open layer architecture, a layer can call any of the layers below it.
    - also called a relaxed layered architecture

By default, layers are often considered closed.

## Typical antipattern: lasagna architecture
***
<p align="center" width="100%">
    <img width="30%" src=resources/anti_pattern.png> 
</p>
Also called _architecture sinkhole anti-pattern._

Lasagna code refers to code whose layers are so complicated and intertwined that making a change in one layer would
necessitate changes in all other layers. Some symptoms:

- Lots of layers
- Large percentage of requests just passed through layers without anything useful happening in most layers
    - In any layered architecture, this will likely be true for a minority of the requests, but it becomes a problem if
      this is the case for a majority of the requests

> ❗**NOTE:**
>
> Making some layers open could help solve this

## Resources
***
- [Layered Architecture](https://www.oreilly.com/library/view/software-architecture-patterns/9781491971437/ch01.html)
- [What is N-Tier Architecture?](https://https://stackify.com/n-tier-architecture/)