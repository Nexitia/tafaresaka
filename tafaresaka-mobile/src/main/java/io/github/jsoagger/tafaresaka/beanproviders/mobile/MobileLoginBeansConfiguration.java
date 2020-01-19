/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile;

import java.util.ArrayList;
import java.util.List;

import io.github.jsoagger.core.i18n.MessageSource;
import io.github.jsoagger.core.ioc.api.annotations.Bean;
import io.github.jsoagger.core.ioc.api.annotations.BeansProvider;
import io.github.jsoagger.core.ioc.api.annotations.Named;
import io.github.jsoagger.core.ioc.api.annotations.Singleton;
import io.github.jsoagger.jfxcore.api.IModelProvider;
import io.github.jsoagger.jfxcore.api.services.Services;
import io.github.jsoagger.jfxcore.engine.components.input.InputInfoView;
import io.github.jsoagger.jfxcore.engine.components.toolbar.vtoolbar.BasicVToolbar;
import io.github.jsoagger.jfxcore.engine.controller.main.DoubleHeaderRootStructureController;
import io.github.jsoagger.jfxcore.engine.controller.main.WizardViewController;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.content.RootStructureContentController;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.layout.FixedLeftRightThreeHPanesViewLayoutManager;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.util.ParentResponsiveMatrix;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.login.LoginRSContentController;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.login.LoginRecoverySummaryController;

/**
 * @author Vonjisoa
 *
 */
@BeansProvider
public class MobileLoginBeansConfiguration {


	@Bean
	@Named("InputInfoView")
	public InputInfoView inputInfoView() {
		return new InputInfoView();
	}

	@Bean
	@Named("LoginMessageSource")
	public MessageSource loginMessageSource() {
		MessageSource messageSource = new MessageSource();
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.getBasenames().add("mobile.views.login.message");
		messageSource.setParentMessageSource((MessageSource) Services.getBean("CoreGeneralMessageSource"));
		return messageSource;
	}

	@Bean
	@Named("LoginRootStructure")
	public DoubleHeaderRootStructureController loginRSView() {
		DoubleHeaderRootStructureController tbc = new DoubleHeaderRootStructureController();
		tbc.setMessageSource(loginMessageSource());
		tbc.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		tbc.addViewDefinition("/mobile/views/login/LoginRS.json");
		return tbc;
	}

	@Bean
	@Named("LoginRSContent")
	public RootStructureContentController loginRSContentView() {
		LoginRSContentController tbc = new LoginRSContentController();
		tbc.setMessageSource(loginMessageSource());
		tbc.addViewDefinition("/mobile/views/login/LoginRSContent.json");
		return tbc;
	}

	@Bean
	@Named("LoginWizard")
	public WizardViewController loginWizard() {
		WizardViewController wizard = new WizardViewController();
		wizard.setLayoutManager(centeredStretchedViewLayoutManager());
		wizard.setMessageSource(loginMessageSource());
		wizard.addViewDefinition("/mobile/views/login/LoginWizardView.json");
		return wizard;
	}

	@Bean
	@Named("corePlatformLoginRecoverViewWizard")
	public WizardViewController corePlatformLoginRecoverView() {
		WizardViewController wizard = new WizardViewController();
		wizard.setLayoutManager(centeredStretchedViewLayoutManager());
		wizard.setMessageSource(loginMessageSource());
		wizard.addViewDefinition("/mobile/views/login/LoginRecoverView.json");
		return wizard;
	}

	@Bean
	@Named("corePlatformLoginRecoverySummaryView")
	public LoginRecoverySummaryController corePlatformLoginRecoverySummaryView() {
		LoginRecoverySummaryController wizard = new LoginRecoverySummaryController();
		wizard.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		wizard.setLayoutManager(centeredStretchedViewLayoutManager());
		wizard.setMessageSource(loginMessageSource());
		wizard.addViewDefinition("/mobile/views/login/LoginRecoverySummaryView.json");
		return wizard;
	}

	@Bean
	@Named("BasicVToolbar")
	public BasicVToolbar basicVToolbar() {
		return new BasicVToolbar();
	}

	@Bean
	@Named("CenteredStretchedViewLayoutManager")
	public FixedLeftRightThreeHPanesViewLayoutManager centeredStretchedViewLayoutManager() {
		FixedLeftRightThreeHPanesViewLayoutManager lyt = new FixedLeftRightThreeHPanesViewLayoutManager();
		lyt.setResponsiveMatrix(centeredStretchedViewLayoutManagerResponsiveMatrix());
		return lyt;
	}

	@Bean
	@Named("CenteredStretchedViewLayoutManagerResponsiveMatrix")
	public ParentResponsiveMatrix centeredStretchedViewLayoutManagerResponsiveMatrix() {
		List<String> matrix = centeredStretchedViewLayoutManagerResponsiveMatrixDefinition();
		ParentResponsiveMatrix lyt = new ParentResponsiveMatrix(matrix);
		return lyt;
	}

	@Bean
	@Singleton
	@Named("CenteredStretchedViewLayoutManagerResponsiveMatrixDefinition")
	public List<String> centeredStretchedViewLayoutManagerResponsiveMatrixDefinition() {
		List<String> data = new ArrayList<>();
		data.add("0#0:1:0#hide::hide");
		return data;
	}
}
