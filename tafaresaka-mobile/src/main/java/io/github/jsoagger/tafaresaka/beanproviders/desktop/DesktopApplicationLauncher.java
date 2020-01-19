/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.desktop;

import io.github.jsoagger.core.ioc.api.BeanFactory;
import io.github.jsoagger.jfxcore.api.services.Services;
import io.github.jsoagger.jfxcore.components.ApplicationProviderUtils;
import io.github.jsoagger.jfxcore.engine.controller.main.AbstractApplicationRunner;
import io.github.jsoagger.jfxcore.engine.controller.main.layout.ViewStructure;

/**
 * @author Ramilafananana VONJISOA
 */
public class DesktopApplicationLauncher  extends AbstractApplicationRunner  {

  /**
   * @{inheritedDoc}
   */
  @Override
  public void initApplication() {

    // Core beans
    BeanFactory.addProviders(ApplicationProviderUtils.getAllProviders());
    BeanFactory.addProvider(DesktopViewStructureConfiguration.class);
    BeanFactory.addProvider(DesktopAppViewsConfiguration.class);

    // do load all declared beans
    BeanFactory.loadBeans();

    // build structure
    this.viewStructure = (ViewStructure) Services.getBean("platformViewStructure");
    this.viewStructure.buildStructure();
  }
}
