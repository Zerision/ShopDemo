# Project Introduction
Basic REST API for an Online Bookstore.
## Framework Choice
There are several reasons for choosing a spring boot framework.<br>
__Performance:__ Quarkus has significant advantages in terms of performance. Due to the use of GraalVM's native image technology, Quarkus has ultra fast startup time and low memory usage, making it suitable for scenarios that require high performance. Spring Boot is relatively slow in performance, but for general enterprise applications, the performance is already sufficient.<br>
__Ecosystem and community support:__ Spring Boot has a large and active community, providing rich documentation, tutorials, and plugins that enable developers to quickly solve problems. However, the ecosystem of Quarkus is relatively new and the community size is relatively small.

# Development Tool
IntelliJ IDEA 2024.1.1

# Using spring/springboot Components
lombok<br>
mapstruct<br>
h2database<br>
mybatis-plus
# Quick Start
1.After installing git, use the command git clone https://github.com/Zerision/ShopDemo.git<br>
2.Import code into IDEA using Maven.<br>
3.Database table structure and data save in /resource/db/<br>
4.Swagger Path: http://localhost:8080/swagger-ui.html<br>
5.Test Unit Class: BookServiceTest,ShopCartServiceTest
