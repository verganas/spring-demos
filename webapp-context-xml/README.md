
The "legacy" way of boostrapping a web application with SpringMVC using web.xml and xml files for context configuration would be :

1) Register a org.springframework.web.context.ContextLoaderListener as a listener in web.xml and specify it's xml configuration file (contextConfigLocation as context-param). This will be the Root WebApplicationContext.

This listener by default uses "org.springframework.web.context.support.XmlWebApplicationContext" as the class for the produced context but this is customizable with the context-param "contextClass" in order to load some other type of context such as: AnnotationConfigWebApplicationContext.

Typically this context hosts common non-frontend beans. These are shared between the child contexts (see #2). The definition of this ContextLoaderListener is OPTIONAL. Non defining it results in each DispatcherServlet working with each own isolated context.

2) Register one or more servlets of class "org.springframework.web.servlet.DispatcherServlet" and configure the context via the init-param "contextConfigLocation". As per doc: Each servlet will operate in its own namespace, loading its own application context with mappings, handlers, etc. Only the root application context as loaded by "org.springframework.web.context.ContextLoaderListener", if any, will be shared.

By default it uses "org.springframework.web.context.support.XmlWebApplicationContext" as the context's class but this is customizable using the servlet init-param "contextClass" in order to load other type of context such as: AnnotationConfigWebApplicationContext.

Note 1: A typical use case for more than 1 DispatcherServlet is when we have a web application mapped at / and a web service api mapped at /api. Each context can have it's own security configuration.

Note 2: Both ContextLoaderListener and DispatcherServlet provide a constructor with parameter an WebApplicationContext context. This constructor is useful in Servlet 3.0+ environments where instance-based registration of listeners/servlets is possible through the "javax.servlet.ServletContext#addListener" / "ServletContext#addServlet" API. See "org.springframework.web.WebApplicationInitializer" for usage examples.
