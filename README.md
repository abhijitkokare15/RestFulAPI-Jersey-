# RESTful API with Jersey

A collection of Java examples for building RESTful web services with Jersey. The repository contains separate sample projects that demonstrate basic endpoints, client responses, content negotiation, and database connectivity.

## Examples

- `DemoRestApi` — a minimal Jersey endpoint that returns a plain-text greeting.
- `Connectivity_REST` — REST endpoints connected to a database.
- `Content_Negoation` — content negotiation example.
- `Response_TO_Client_Path_param` — returning data and looking up records using a path parameter.
- `Response_TO_Client_XML` and `Response_TO_Client_XML2` — XML response examples.

Each example is a standalone Maven web application. Start with `DemoRestApi` if you are new to Jersey.

## Requirements

- Java 8 or later
- Maven
- Apache Tomcat 9 (or another servlet container compatible with the `javax.servlet` API)

## Run the basic example

1. Open a terminal in the `DemoRestApi` directory.
2. Build the WAR:

   ```bash
   mvn clean package
   ```

3. Deploy `target/DemoRestApi.war` to Tomcat 9.
4. Start Tomcat and open:

   ```text
   http://localhost:8080/DemoRestApi/api/hello
   ```

The endpoint returns:

```text
Hello, REST API is working!
```

## Add an endpoint

Jersey resources are Java classes annotated with `@Path`. For example, the basic resource is in:

```text
DemoRestApi/src/main/java/com/abhijit/DemoRestApi/MyResource.java
```

The Jersey servlet is mapped to `/api/*` in `DemoRestApi/src/main/webapp/WEB-INF/web.xml`.
