package dk.sdu.cbse;

import dk.sdu.cbse.common.services.IPluginService;
import dk.sdu.cbse.common.services.IPostProcessorService;
import dk.sdu.cbse.common.services.IProcessorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

@Configuration
public class AppConfiguration {

    @Bean
    public App app(){
        return new App(getPluginServices(),getProcessService(),getPostProcessingService());
    }

    @Bean
    public List<IPluginService> getPluginServices() {
        return ServiceLoader.load(IPluginService.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }
    @Bean
    public List<IProcessorService> getProcessService() {
        return ServiceLoader.load(IProcessorService.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }
    @Bean
    public List<IPostProcessorService> getPostProcessingService() {
        return ServiceLoader.load(IPostProcessorService.class).stream().map(ServiceLoader.Provider::get).collect(Collectors.toList());
    }
}
