# CSD214 w26 Lecture 8 Starter App
- [Lecture 8...](https://docs.google.com/document/d/1DqL55GGoQbX6LO9NgkX5eCzmMfDRyoH_PEh4T4bo9QQ/edit?usp=sharing)

The vanishing Act
    - In Lab 5, we had to write all the logic ourselves, but in lab 6 we only wrote method names.Spring Data JPA reads those names and automatically generates the queries, so we don't need to write SQL or loops.

The Power of Annotations
    - If we forget @Service, Spring won't recognize the class, so it won't create it or inject it. This would cause errors because the dependency would be missing. 

Constructor Injection vs. New
    - Constructor injection is better because Spring handles creating objects for us. It keeps the code more flexible and easier to test, while using new makes things more tightly connected. 

Profiles vs. Lab 5 Menu
    - Profiles are better because they let us switch environments (like dev and prod) without changing code. This is more practical and closer to real-world applications than using a menu.

Quiz Answers: 
    1. B
    2. C
    3. B
    4. B
    5. C
    6. B
    7. B
    8. B
    9. B
    10. B
    11. B
    12. B
    13. B
    14. A
    15. B
    16. B
    17. A
    18. B
    19. B
    20. B