package br.com.jcmar.cadastroClientes.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000", "https://n-front-full-stack-cliente.vercel.app/")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Ajuste conforme necessário
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite credenciais, se necessário

    }
}