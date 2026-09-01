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
19. @Column: Indicates that a field is mapped to a column in a database table in JPA, allowing for the customization of column properties such as name, length, and nullability.
20. @ManyToOne(cascade = CascadeType.ALL): Indicates a many-to-one relationship between two entities in JPA, with cascading operations enabled, allowing for the automatic propagation of certain operations (such as persist, merge, remove) from the parent entity to the associated child entities.
21. @Qualifier: Used to specify which bean should be injected when multiple beans of the same type are available, allowing for more precise dependency injection in Spring.
22. @Query: Used to define a custom query in a Spring Data repository method, allowing for the execution of specific database queries using JPQL or native SQL.
23. @SpringBootTest: Indicates that a test class should run with the Spring Boot test support, allowing for the loading of the application context and the execution of integration tests.
24. @Test: Indicates that a method is a test method in JUnit, allowing for the execution of unit tests and the verification of expected behavior.
25. @Transactional: Indicates that a method or class should be executed within a transactional context, allowing for the management of database transactions and ensuring data consistency.
26. @RequestParam: Used to bind HTTP request parameters to method parameters in a controller class, allowing for the extraction of query parameters from the request URL.
27. @Fetch: Used to specify the fetching strategy for a relationship in JPA, allowing for the control of how related entities are loaded (eagerly or lazily) from the database.
28. @OneToMany(mappedBy = "category", fetch = FetchType.LAZY): Indicates a one-to-many relationship between two entities in JPA, with the "mappedBy" attribute specifying the owning side of the relationship and the "fetch" attribute specifying that related entities should be loaded lazily from the database.
    * FetchType.LAZY: Specifies that the related entities should be loaded lazily, meaning they will be fetched only when accessed, allowing for better performance and reduced memory usage.
    * You can use FetchType.EAGER to specify that the related entities should be loaded eagerly, meaning they will be fetched immediately along with the parent entity.
    * @Fetch(FetchMode.JOIN): Specifies that the related entities should be fetched using a SQL JOIN operation, allowing for the retrieval of related data in a single query.
    * @Fetch(FetchMode.SELECT): Specifies that the related entities should be fetched using separate SQL SELECT statements, allowing for the retrieval of related data in multiple queries.
    * @Fetch(FetchMode.SUBSELECT): Specifies that the related entities should be fetched using a SQL subselect query, allowing for the retrieval of related data in a single query with a subselect.
    * @BatchSize(size = 10): Specifies the batch size for fetching related entities in JPA, allowing for the optimization of database queries by retrieving multiple related entities in a single batch.