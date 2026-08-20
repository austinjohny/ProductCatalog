# Lombok
1. @Getter: Generates getter methods for all fields in a class.
2. @Setter: Generates setter methods for all fields in a class.

# Spring Framework
1. @Component: Indicates that a class is a Spring component, allowing Spring to automatically detect and register it as a bean.
2. @Service: Indicates that a class is a service component in the Spring framework, typically used to define business logic.
3. @RestController: Indicates that a class is a RESTful web service controller, allowing it to handle HTTP requests and responses.
4. @Autowired: Used for automatic dependency injection, allowing Spring to resolve and inject collaborating beans into a class.
5. @RequestMapping: Used to map HTTP requests to specific handler methods in a controller class, allowing for flexible routing of requests. 
    * @GetMapping: A specialized version of @RequestMapping for handling HTTP GET requests.
    * @PostMapping: A specialized version of @RequestMapping for handling HTTP POST requests.
    * @PutMapping: A specialized version of @RequestMapping for handling HTTP PUT requests.
6. @PathVariable: Used to extract values from the URI path and bind them to method parameters in a controller class.
7. @Configuration: Indicates that a class contains Spring configuration and bean definitions, allowing it to be used as a source of bean definitions for the application context.
8. @Bean: Indicates that a method produces a bean to be managed by the Spring container, allowing for programmatic bean creation and configuration.
9. @SpringBootApplication: A convenience annotation that combines @Configuration, @EnableAutoConfiguration, and @ComponentScan, indicating that a class is the main entry point for a Spring Boot application and enabling component scanning and auto-configuration.
10. @RequestBody: Used to bind the HTTP request body to a method parameter in a controller class, allowing for the automatic deserialization of JSON or XML data into Java objects.
11. @ControllerAdvice: Indicates that a class provides global exception handling and advice for controllers, allowing for centralized error handling and response customization.
12. @ExceptionHandler: Used to define a method that handles specific exceptions thrown by controller methods, allowing for custom error handling and response generation.
13. @MappedSuperclass: Indicates that a class is a mapped superclass in JPA, allowing it to be used as a base class for entity classes without being directly mapped to a database table.
14. @Id: Indicates that a field is the primary key of an entity in JPA, allowing it to be used for uniquely identifying instances of the entity.
15. @Entity: Indicates that a class is a JPA entity, allowing it to be mapped to a database table and managed by the JPA provider.
16. @OneToMany: Indicates a one-to-many relationship between two entities in JPA, allowing for the mapping of a collection of related entities to a single entity.
17. @ManyToOne: Indicates a many-to-one relationship between two entities in JPA, allowing for the mapping of a single entity to multiple related entities.
18. @Repository: Indicates that a class is a Spring Data repository, allowing it to provide CRUD operations and query methods for a specific entity type.