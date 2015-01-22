
The verbose "programmatic" way of boostrapping a web application with SpringMVC using java-only configuration would be:

1) Create a class that implements "WebApplicationInitializer". This class will be called back at ServletContext startup by Spring Framework when running on Servlet 3.0+ servers.

2) Inside startup callback programmatically create a AnnotationConfigWebApplicationContext. This context class provides a register method that takes a @Configuration annotated class to configure the context. This will be the Root WebApplicationContext.

3) We can then create a ContextLoaderListener by passing the newly instantiated context to it's constructor. And register it to the ServletContext.

Example:

// Create the 'root' Spring application context
AnnotationConfigWebApplicationContext rootContext =
        new AnnotationConfigWebApplicationContext();
rootContext.register(RootConfig.class);

// Manage the lifecycle of the root application context
container.addListener(new ContextLoaderListener(rootContext));

4) Same approach will be followed for each DispatcherServlet we may need. We have to register instances of DispatcherServlet with the context.

Example:

// Create the dispatcher servlet's Spring application context
AnnotationConfigWebApplicationContext webContext =
        new AnnotationConfigWebApplicationContext();
webContext.register(WebConfig.class);

// Register and map the dispatcher servlet
ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(webContext));
dispatcher.setLoadOnStartup(1);
dispatcher.addMapping("/");


5) Inside our WebConfig class we'll have to create a new InternalResourceViewResolver bean (or other type of view resolver) to handle our views:

@Bean
public ViewResolver viewResolver() {
    InternalResourceViewResolver resolver =
            new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/views/");
    resolver.setSuffix(".jsp");
    resolver.setExposeContextBeansAsAttributes(true);
    return resolver;
}
