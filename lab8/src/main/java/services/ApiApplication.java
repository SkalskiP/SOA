package services;

import io.swagger.jaxrs.config.BeanConfig;
import services.collection.CollectionService;
import services.movie.MovieService;
import services.person.PersonService;
import services.user.UserService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ApiApplication extends Application {

    HashSet<Object> singletons = new HashSet<Object>();

    public ApiApplication() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/rest");
        beanConfig.setResourcePackage("services");
        beanConfig.setTitle("NetFix");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<Class<?>>();

        set.add(MovieService.class);
        set.add(UserService.class);
        set.add(CollectionService.class);
        set.add(PersonService.class);

        set.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        set.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
