import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.kpfu.itis.pavelvladimirov.Earth;
import ru.kpfu.itis.pavelvladimirov.Mars;
import ru.kpfu.itis.pavelvladimirov.Sun;

/**
 * Created by Павел on 21.03.2016.
 */
@Configuration
@ComponentScan(basePackages = ("ru.kpfu.itis.pavelvladimirov"))
public class JavaConfig {

    @Bean
    @Qualifier("earth")
    public Earth earth(){
        return new Earth();
    }

    @Bean
    @Qualifier("sun")
    public Sun sun() {
        return new Sun();
    }

    @Bean
    @Qualifier("mars")
    public Mars mars() {
        return new Mars();
    }

}
