package main;


import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class ServiceLauncher {

  private ServiceLauncher() {

  }

  public void main(String[] args) {
    ConfigurableApplicationContext context = SpringApplication.run(App.class);

  }
}
