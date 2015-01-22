A convenience class that we can use in place of our own WebAppInitializer implementation is AbstractAnnotationConfigDispatcherServletInitializer:

1) This class has about the same implementation as our manually crafted WebAppInitializer.

2) It requires us to implement the methods: getServletMappings(), getRootConfigClasses(), getServletConfigClasses(). Optionally we can also provide servlet filter. If the config methods return config classes AbstractAnnotationConfigDispatcherServletInitializer creates a ContextLoaderListener or/and DispatcherServlet accordingly.




The typical way and concise way to configure Spring MVC is use the AbstractAnnotationConfigDispatcherServletInitializer previously described while annotating the DispatcherServlet's context config class (i.e. WebConfig) with @EnableWebMvc:

1) @EnableWebMvc essentially imports the Spring MVC configuration from WebMvcConfigurationSupport. WebMvcConfigurationSupport provides a series of HandlerMapping, HandlerAdapter and HandlerExceptionResolverComposite classes in the request processing pipeline. See: WebMvcConfigurationSupport javadocs for info.

2) If we want to customize the configuration our config class must implement WebMvcConfigurer or more likely extend the empty method base class WebMvcConfigurerAdapter.

3) If advanced configuration is needed which is not supported by WebMvcConfigurerAdapter we can remove @EnableWebMvc and our config class can directly extend WebMvcConfigurationSupport.
