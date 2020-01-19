/**
 *
 */
package io.github.jsoagger.starter;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;


/**
 * Application  runner.
 */
@SpringBootApplication
@Import({CoreStartupBeans.class, MCPersistenceConfig.class})
@ComponentScan("io.github.jsoagger.starter")
public class SpringBootStarter {


  public static void main(String[] args) {
    new SpringApplicationBuilder(SpringBootStarter.class)
    .logStartupInfo(true)
    .run(args);
  }
}
