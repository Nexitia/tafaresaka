/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import io.github.jsoagger.core.i18n.MessageSource;
import io.github.jsoagger.core.ioc.api.BeanFactory;
import io.github.jsoagger.core.ioc.api.annotations.Bean;
import io.github.jsoagger.core.ioc.api.annotations.BeansProvider;
import io.github.jsoagger.core.ioc.api.annotations.Eager;
import io.github.jsoagger.core.ioc.api.annotations.Named;
import io.github.jsoagger.core.ioc.api.annotations.Singleton;
import io.github.jsoagger.jfxcore.api.IModelProvider;
import io.github.jsoagger.jfxcore.api.IParentResponsiveMatrix;
import io.github.jsoagger.jfxcore.api.css.IStylesheetManager;
import io.github.jsoagger.jfxcore.api.presenter.ModelIconPresenter;
import io.github.jsoagger.jfxcore.api.presenter.ModelIdentityPresenter;
import io.github.jsoagger.jfxcore.api.services.ApplicationContextService;
import io.github.jsoagger.jfxcore.api.services.CommonComponentsServices;
import io.github.jsoagger.jfxcore.api.services.GlobalComponentsService;
import io.github.jsoagger.jfxcore.api.services.Services;
import io.github.jsoagger.jfxcore.api.services.ViewConfigurationService;
import io.github.jsoagger.jfxcore.engine.components.css.StyleSheetsManager;
import io.github.jsoagger.jfxcore.engine.controller.main.StandardController;
import io.github.jsoagger.jfxcore.engine.controller.main.layout.BottomTabPaneViewStructure;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.layout.FullFlowContentLayoutManager;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.layout.FullTableStructureContentLayoutManager;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.layout.NoFixedPaneTableStructureContentLayoutManager;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.util.ParentResponsiveMatrix;
import io.github.jsoagger.jfxcore.engine.providers.integration.CommonCompsServices;
import io.github.jsoagger.jfxcore.engine.providers.integration.JSoaggerFXApplicationContextService;
import io.github.jsoagger.jfxcore.engine.providers.integration.JSonViewConfigurationService;
import io.github.jsoagger.jfxcore.engine.providers.integration.JsonGlobalCompsService;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.comps.StaticModelFlowCell;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.views.misc.AboutViewProcessor;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.views.misc.LicenceViewProcessor;

/**
 * @author Ramilafananana VONJISOA
 *
 */
@BeansProvider
public class MobileViewStructureBeansConfiguration {

	static String REMOTE_SERVICES = "http://localhost:8080/jsoagger/serv/core/";

	/**
	 * @return
	 */
	@Bean
	@Named("cloudServicesProperties")
	public static Properties cloudServicesProperties() {
		Properties properties = new Properties();
		properties.put("remoteServerLocation", REMOTE_SERVICES);
		properties.put("authenticationApi", "/api/authentication");
		return properties;
	}

	@Bean
	@Singleton
	@Named("platformViewStructure")
	public BottomTabPaneViewStructure platformViewStructure() {
		BottomTabPaneViewStructure structure = new BottomTabPaneViewStructure();
		structure.setScreenProperties(screenProperties());
		structure.setStyleSheetManager(styleSheetManager());
		structure.setPlatformProperties(platformProperties());
		return structure;
	}

	@Bean
	@Singleton
	@Named("platformProperties")
	public Properties platformProperties() {
		Properties platformProperties = new Properties();
		platformProperties.setProperty("tempFolderPath", "temp");
		platformProperties.setProperty("applicationDataFolderPath", "temp");
		platformProperties.setProperty("localNotificationsFolderPath", "temp");
		platformProperties.setProperty("applicationWindowName", "Tafaresaka");
		platformProperties.setProperty("applicationTitle", "Tafaresaka");
		platformProperties.setProperty("fullScreen", "false");
		platformProperties.setProperty("platformRootStructureId", "MobileLayoutRSView");
		platformProperties.setProperty("loginRootStructureId", "LoginRootStructure");
		platformProperties.setProperty("platformType", "SIMUL_MOBILE");
		platformProperties.setProperty("applicationViewConfigMode", "offline");
		platformProperties.setProperty("applicationConnexionMode", "disallow_anonymous");
		platformProperties.setProperty("full.screen.support", "false");
		return platformProperties;
	}

	@Bean
	@Singleton
	@Named("styleSheetManager")
	public IStylesheetManager styleSheetManager() {
		StyleSheetsManager sheetsManager = new StyleSheetsManager();
		sheetsManager.getStyleSheetsPath().add("classpath:/css/color/accent/green.css");
		sheetsManager.getStyleSheetsPath().add("classpath:/css/color/primary/green.css");
		sheetsManager.getStyleSheetsPath().add("classpath:/css/content/light/light-mobile.css");
		sheetsManager.getStyleSheetsPath().add("classpath:/css/undecorator/undecorator.css");
		sheetsManager.getStyleSheetsPath().add("classpath:/io/github/jsoagger/core/jfx/controller/login/login.css");
		sheetsManager.getStyleSheetsPath().add("classpath:/css/tafaresaka-mobile.css");
		return sheetsManager;
	}

	@Bean
	@Singleton
	@Named("customStyleSheetsPath")
	public List<String> customStyleSheetsPath() {
		List<String> d = new ArrayList<>();
		d.add("classpath:/css/tafaresaka-mobile.css");
		return d;
	}

	@Bean
	@Singleton
	@Named("wizardProperties")
	public Properties providesWizardProperties() {
		Properties wizardProperties = new Properties();
		wizardProperties.setProperty("width", "300");
		wizardProperties.setProperty("height", "400");
		return wizardProperties;
	}

	@Bean
	@Singleton
	@Named("screenProperties")
	public Properties screenProperties() {
		Properties screenProperties = new Properties();
		screenProperties.setProperty("width", "340");
		screenProperties.setProperty("height", "600");
		screenProperties.setProperty("minWidth", "340");
		screenProperties.setProperty("minHeight", "600");
		screenProperties.setProperty("maxWidth", "340");
		screenProperties.setProperty("maxHeight", "600");
		return screenProperties;
	}

	@Bean
	@Singleton
	@Named("ApplicationContextService")
	public ApplicationContextService appContextService() {
		JSoaggerFXApplicationContextService mobile = new JSoaggerFXApplicationContextService();
		return mobile;
	}

	@Bean
	@Singleton
	@Named("ViewConfigurationService")
	public ViewConfigurationService viewConfigurationService() {
		JSonViewConfigurationService viewConfigurationService = new JSonViewConfigurationService();
		return viewConfigurationService;
	}

	@Bean
	@Singleton
	@Named("GlobalComponentsService")
	public GlobalComponentsService jsonGlobalCompsService() {
		JsonGlobalCompsService jsonGlobalComps = new JsonGlobalCompsService();
		jsonGlobalComps.getFiles().add("/io/github/jsoagger/jfxcore/demoapp/common/CoreActions.json");
		jsonGlobalComps.getFiles().add("/io/github/jsoagger/jfxcore/demoapp/common/CoreActionsModel.json");
		jsonGlobalComps.getFiles().add("/io/github/jsoagger/jfxcore/demoapp/common/CoreAttributes.json");
		jsonGlobalComps.getFiles().add("/io/github/jsoagger/jfxcore/demoapp/common/CoreComponents.json");

		jsonGlobalComps.getFiles().add("/io/github/jsoagger/jfxcore/demoapp/common/common-components.json");
		jsonGlobalComps.getFiles().add("/io/github/jsoagger/jfxcore/demoapp/common/element-components.json");
		jsonGlobalComps.getFiles().add("/io/github/jsoagger/jfxcore/demoapp/common/search-components.json");
		jsonGlobalComps.loadFiles();
		return jsonGlobalComps;
	}

	@Bean
	@Singleton
	@Named("CommonCompsServices")
	public CommonCompsServices commonCompsServices() {
		CommonCompsServices commonCompsServices = new CommonCompsServices();
		return commonCompsServices;
	}

	@Bean
	@Singleton
	@Named("IntegrationService")
	public Services integrationService() {
		Services services = Services.instance();
		services.setAppContextService(
				(ApplicationContextService) BeanFactory.instance().getBean("ApplicationContextService"));
		services.setCommonComponentsServices(
				(CommonComponentsServices) BeanFactory.instance().getBean("CommonCompsServices"));
		services.setGlobalConfigService(
				(GlobalComponentsService) BeanFactory.instance().getBean("GlobalComponentsService"));
		services.setViewConfigurationService(
				(ViewConfigurationService) BeanFactory.instance().getBean("ViewConfigurationService"));
		return services;
	}

	@Bean
	@Named("CommonDashboardMessageSource")
	public MessageSource commonDashboardMessageSource() {
		MessageSource messageSource = new MessageSource();
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.getBasenames().add("rootstructure.message");
		messageSource.setParentMessageSource((MessageSource) Services.getBean("CoreGeneralMessageSource"));
		return messageSource;
	}

	@Bean
	@Named("RooStructureMessageSource")
	public MessageSource rooStructureMessageSource() {
		MessageSource messageSource = new MessageSource();
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.getBasenames().add("rootstructure.message");
		messageSource.setParentMessageSource((MessageSource) Services.getBean("CoreGeneralMessageSource"));
		return messageSource;
	}

	@Bean
	@Singleton
	@Eager
	@Named("RootMessageSource")
	public MessageSource RootMessageSource() {
		MessageSource messageSource = new MessageSource();
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.getBasenames().add("rootstructure.message");
		messageSource.setParentMessageSource((MessageSource) Services.getBean("CoreGeneralMessageSource"));
		return messageSource;
	}

	@Bean
	@Named("GetStartedWelcomeView")
	public StandardController GetStartedWelcomeView() {
		StandardController c = new StandardController();
		c.setModelProvider((IModelProvider) BeanFactory.instance().getBean("ApplicationRootContainerModelLoader"));
		c.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		c.addViewDefinition("/rootstructure/GetStartedWelcomeView.json");
		return c;
	}


	@Bean
	@Named("UserMenuView")
	public StandardController userMenuView() {
		StandardController pmc = new StandardController();
		pmc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		pmc.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		pmc.addViewDefinition("/mobile/views/menu/UserMenu.json");
		return pmc;
	}


	@Bean
	@Named("NoFixedPaneTableStructureContentLayoutManager")
	public NoFixedPaneTableStructureContentLayoutManager noFixedPaneTableStructureContentLayoutManager() {
		NoFixedPaneTableStructureContentLayoutManager r = new NoFixedPaneTableStructureContentLayoutManager();
		r.setResponsiveMatrix(
				(IParentResponsiveMatrix) Services.getBean("MobileContentFlowViewLayoutManagerResponsiveMatrix"));
		return r;
	}

	@Bean
	@Named("MobileContentFlowViewLayoutManager")
	public FullFlowContentLayoutManager MobileContentFlowViewLayoutManager() {
		FullFlowContentLayoutManager r = new FullFlowContentLayoutManager();
		r.setResponsiveMatrix(
				(IParentResponsiveMatrix) Services.getBean("MobileContentFlowViewLayoutManagerResponsiveMatrix"));
		return r;
	}

	@Bean
	@Named("MobileContentFlowViewLayoutManagerResponsiveMatrix")
	public ParentResponsiveMatrix MobileContentFlowViewLayoutManagerResponsiveMatrix() {
		List<String> d = MobileContentFlowViewLayoutManagerResponsiveMatrixDefinition();
		ParentResponsiveMatrix matrix = new ParentResponsiveMatrix(d);
		return matrix;
	}

	@Bean
	@Named("MobileContentFlowViewLayoutManagerResponsiveMatrixDefinition")
	public List<String> MobileContentFlowViewLayoutManagerResponsiveMatrixDefinition() {
		List<String> c = new ArrayList<String>();
		c.add("0#0:0.98:0#hide::hide");
		return c;
	}

	@Bean
	@Named("ScrolLessCenteredFullFlowLayoutManager")
	public FullTableStructureContentLayoutManager ScrolLessCenteredFullFlowLayoutManager() {
		FullTableStructureContentLayoutManager lyt = new FullTableStructureContentLayoutManager();
		lyt.setVerticalScroll(false);
		lyt.setResponsiveMatrix(
				(IParentResponsiveMatrix) Services.getBean("ScrolLessCenteredFullFlowLayoutManagerMatrix"));
		return lyt;
	}

	@Bean
	@Named("ScrolLessCenteredFullFlowLayoutManagerMatrix")
	public ParentResponsiveMatrix ScrolLessCenteredFullFlowLayoutManagerMatrix() {
		List<String> matrix = (List<String>) Services.getBean("ScrolLessCenteredFullFlowLayoutManagerMatrixDefinition");
		ParentResponsiveMatrix lyt = new ParentResponsiveMatrix(matrix);
		return lyt;
	}

	@Bean
	@Singleton
	@Named("ScrolLessCenteredFullFlowLayoutManagerMatrixDefinition")
	public List<String> ScrolLessCenteredFullFlowLayoutManagerMatrixDefinition() {
		List<String> data = new ArrayList<>();
		data.add("0#0:1:0#hide::hide");
		return data;
	}


	@Bean
	@Named("MobilePrimaryHeaderToolbarResponsiveMatrix")
	public ParentResponsiveMatrix MobilePrimaryHeaderToolbarResponsiveMatrix() {
		List<String> d = MobilePrimaryHeaderToolbarResponsiveMatrixDefinition();
		ParentResponsiveMatrix matrix = new ParentResponsiveMatrix(d);
		return matrix;
	}

	@Bean
	@Named("MobilePrimaryHeaderToolbarResponsiveMatrixDefinition")
	public List<String> MobilePrimaryHeaderToolbarResponsiveMatrixDefinition() {
		List<String> c = new ArrayList<String>();
		c.add("0#0.15:0.85:0.0#::hide");
		return c;
	}

	@Bean
	@Named("StaticModelFlowCell")
	public StaticModelFlowCell staticModelFlowCell() {
		StaticModelFlowCell m = new StaticModelFlowCell();
		m.setIdentityPresenter((ModelIdentityPresenter) Services.getBean("ModelNameIdentityPresenter"));
		m.setIconPresenter((ModelIconPresenter) Services.getBean("AdminStaticIconPresenter"));
		return m;
	}

	@Bean
	@Singleton
	@Named("LicenceView")
	public StandardController licenceView() {
		StandardController c = new StandardController();
		c.setModelProvider((IModelProvider) BeanFactory.instance().getBean("ApplicationRootContainerModelLoader"));
		c.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		c.addViewDefinition("/mobile/views/menu/LicenceView.json");
		return c;
	}

	@Bean
	@Named("LicenceViewProcessor")
	public LicenceViewProcessor licenceViewProcessor() {
		LicenceViewProcessor m = new LicenceViewProcessor();
		return m;
	}

	@Bean
	@Named("AboutViewProcessor")
	public AboutViewProcessor aboutViewProcessor() {
		AboutViewProcessor m = new AboutViewProcessor();
		return m;
	}

	@Bean
	@Named("AboutView")
	public StandardController aboutView() {
		StandardController c = new StandardController();
		c.setModelProvider((IModelProvider) BeanFactory.instance().getBean("ApplicationRootContainerModelLoader"));
		c.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		c.addViewDefinition("/mobile/views/menu/AboutView.json");
		return c;
	}
}
