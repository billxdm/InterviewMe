import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by dxiong15 on 7/11/17.
 */
public class ServiceLaunchBase {

  private ConfigurableApplicationContext configurableApplicationContext;


  /*
  protected void startApplication(boolean throwException) {
    try {
      this.configurableApplicationContext = new SpringApplicationBuilder(App.class)
          .web(false).run("--spring.batch.job.enabled=false");
      this.fileWatcher = configurableApplicationContext.getBean(VFSFileWatcherWrapper.class);
      this.fileWatcher.setDelayToWatchMs(100);
      fileWatcher.start();
    } catch (Exception e) {
      if(throwException) {
        throw e;
      }
      e.printStackTrace();
    }
   */
}
