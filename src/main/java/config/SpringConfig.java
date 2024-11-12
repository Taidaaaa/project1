package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "service")  // Вказуємо пакет, в якому будуть шукати компоненти Spring
public class SpringConfig {

    private static AnnotationConfigApplicationContext springContext;

    public SpringConfig() {
        // Ініціалізація Spring контексту, який сканує пакети
        springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
    }

    // Метод для отримання контексту
    public static AnnotationConfigApplicationContext getContext() {
        return springContext;
    }
}

