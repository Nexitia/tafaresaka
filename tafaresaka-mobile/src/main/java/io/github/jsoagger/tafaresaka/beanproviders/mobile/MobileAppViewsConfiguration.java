/**
 *
 */
package io.github.jsoagger.tafaresaka.beanproviders.mobile;

import java.util.ArrayList;
import java.util.List;

import io.github.jsoagger.core.bridge.operation.IOperation;
import io.github.jsoagger.core.i18n.MessageSource;
import io.github.jsoagger.core.ioc.api.annotations.Bean;
import io.github.jsoagger.core.ioc.api.annotations.BeansProvider;
import io.github.jsoagger.core.ioc.api.annotations.Named;
import io.github.jsoagger.core.ioc.api.annotations.Singleton;
import io.github.jsoagger.jfxcore.api.IModelProvider;
import io.github.jsoagger.jfxcore.api.IParentResponsiveMatrix;
import io.github.jsoagger.jfxcore.api.MenuConfigurationProvider;
import io.github.jsoagger.jfxcore.api.presenter.ModelIconPresenter;
import io.github.jsoagger.jfxcore.api.presenter.ModelIdentityPresenter;
import io.github.jsoagger.jfxcore.api.security.ILoginSessionHolder;
import io.github.jsoagger.jfxcore.api.services.Services;
import io.github.jsoagger.jfxcore.api.view.IViewLayoutManager;
import io.github.jsoagger.jfxcore.engine.components.dialog.impl.OkCancelDialog;
import io.github.jsoagger.jfxcore.engine.components.form.bloc.ProcessViewFormBlocContent;
import io.github.jsoagger.jfxcore.engine.components.form.fieldset.layout.menu.FieldsetWithMenuLayout;
import io.github.jsoagger.jfxcore.engine.components.list.impl.DefaultModelListCell;
import io.github.jsoagger.jfxcore.engine.components.listform.DoActionPresenterFactory;
import io.github.jsoagger.jfxcore.engine.components.menu.PrimaryMenuProvider;
import io.github.jsoagger.jfxcore.engine.components.pagination.MobileLoadMorePaginationBar;
import io.github.jsoagger.jfxcore.engine.components.presenter.MultiPresenterFactory;
import io.github.jsoagger.jfxcore.engine.controller.PrimaryMenuController;
import io.github.jsoagger.jfxcore.engine.controller.main.DoubleHeaderRootStructureController;
import io.github.jsoagger.jfxcore.engine.controller.main.StandardController;
import io.github.jsoagger.jfxcore.engine.controller.main.StandardTabPaneController;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.content.RootStructureContentController;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.header.ToolbarController;
import io.github.jsoagger.jfxcore.engine.controller.roostructure.util.ParentResponsiveMatrix;
import io.github.jsoagger.tafaresaka.beanproviders.loaders.RootStructureModelLoader;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.action.LocalStorage;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.action.LoginOperation;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.action.LogoutOperation;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.comps.CopyRighWithLogo;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.comps.WhiteCopyRightWithLogo;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.views.contacts.ContactsController;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.views.feeds.RssFeedsController;
import io.github.jsoagger.tafaresaka.beanproviders.mobile.views.messages.MessagesController;
import io.github.jsoagger.tafaresaka.beanproviders.operations.LoadContainerByOidOperation;

/**
 * @author Ramilafananana VONJISOA
 *
 */
@BeansProvider
public class MobileAppViewsConfiguration {


	@Bean
	@Named("ContactsView")
	public StandardController contactsView() {
		ContactsController pmc = new ContactsController();
		pmc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		pmc.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		pmc.addViewDefinition("/mobile/views/contacts/ContactView.json");
		return pmc;
	}

	@Bean
	@Named("MessagesView")
	public StandardController messagesView() {
		MessagesController pmc = new MessagesController();
		pmc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		pmc.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		pmc.addViewDefinition("/mobile/views/messages/MessagesView.json");
		return pmc;
	}

	@Bean
	@Named("RssFeedsView")
	public StandardController rssFeedsView() {
		RssFeedsController pmc = new RssFeedsController();
		pmc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		pmc.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		pmc.addViewDefinition("/mobile/views/rssFeeds/RssFeedsView.json");
		return pmc;
	}

	@Bean
	@Named("LoginSessionHolder")
	public ILoginSessionHolder localStorage() {
		return LocalStorage.instance();
	}

	@Bean
	@Named("LocalStorage")
	public LocalStorage localStorageSame() {
		return LocalStorage.instance();
	}

	@Bean
	@Singleton
	@Named("LoginOperation")
	public IOperation loginOperation() {
		return new LoginOperation();
	}

	@Bean
	@Singleton
	@Named("LogoutOperation")
	public IOperation logoutOperation() {
		return new LogoutOperation();
	}


	@Bean
	@Named("OkCancelDialog")
	public OkCancelDialog okCancelDialog() {
		OkCancelDialog c = new OkCancelDialog();
		return c;
	}


	@Bean
	@Named("CopyRightWithLogo")
	public CopyRighWithLogo copyRightWithLogo() {
		CopyRighWithLogo c = new CopyRighWithLogo();
		return c;
	}

	@Bean
	@Named("WhiteCopyRightWithLogo")
	public WhiteCopyRightWithLogo whiteCopyRightWithLogo() {
		WhiteCopyRightWithLogo c = new WhiteCopyRightWithLogo();
		return c;
	}


	@Bean
	@Named("UserMenuAdminItemCellFactory")
	public DefaultModelListCell userMenuAdminItemCellFactory() {
		DefaultModelListCell c = new DefaultModelListCell();
		return c;
	}

	@Bean
	@Named("ProcessViewFormBlocContent")
	public ProcessViewFormBlocContent processViewFormBlocContent() {
		ProcessViewFormBlocContent c = new ProcessViewFormBlocContent();
		return c;
	}

	@Bean
	@Named("FieldsetWithMenuLayout")
	public FieldsetWithMenuLayout fiedsetSelectorMenuRow() {
		FieldsetWithMenuLayout c = new FieldsetWithMenuLayout();
		return c;
	}


	@Bean
	@Named("DoActionPresenterFactory")
	public DoActionPresenterFactory doActionPresenterFactory() {
		DoActionPresenterFactory p = new DoActionPresenterFactory();
		return p;
	}

	@Bean
	@Named("UserMenuAdminItemListCellPresenter")
	public MultiPresenterFactory userMenuAdminItemListCellPresenter() {
		MultiPresenterFactory c = new MultiPresenterFactory();
		c.setIdentityPresenter((ModelIdentityPresenter) Services.getBean("ModelNameIdentityPresenter"));
		c.setIconPresenter((ModelIconPresenter) Services.getBean("AdminStaticIconPresenter"));
		return c;
	}


	@Bean
	@Singleton
	@Named("ApplicationRootContainerModelLoader")
	public RootStructureModelLoader rootStructureModelLoader() {
		return new RootStructureModelLoader();
	}


	@Bean
	@Named("MobileLoadMorePaginationBar")
	public MobileLoadMorePaginationBar mobileLoadMorePaginationBar() {
		return new MobileLoadMorePaginationBar();
	}

	@Bean
	@Singleton
	@Named("LoadContainerByOidOperation")
	public LoadContainerByOidOperation loadContainerByOidOperation() {
		return new LoadContainerByOidOperation();
	}

	@Bean
	@Named("MobilePrimaryHeaderToolbarView")
	public ToolbarController MobilePrimaryHeaderToolbarView() {
		ToolbarController tbc = new ToolbarController();
		tbc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		tbc.setResponsiveMatrix(
				(IParentResponsiveMatrix) Services.getBean("MobilePrimaryHeaderToolbarResponsiveMatrix"));
		tbc.addViewDefinition("/mobile/PrimaryHeaderToolbarView.json");
		return tbc;
	}

	@Bean
	@Named("MobilePrimaryHeaderToolbarResponsiveMatrix")
	public ParentResponsiveMatrix MobilePrimaryHeaderToolbarResponsiveMatrix() {
		List<String> m = MobilePrimaryHeaderToolbarResponsiveMatrixDefinition();
		ParentResponsiveMatrix p = new ParentResponsiveMatrix(m);
		return p;
	}

	@Bean
	@Named("MobilePrimaryHeaderToolbarResponsiveMatrixDefinition")
	public List<String> MobilePrimaryHeaderToolbarResponsiveMatrixDefinition() {
		List<String> s = new ArrayList<>();
		s.add("0#0.40:0.60:0.10#::hide");
		return s;
	}

	@Bean
	@Named("MobileLayoutRSContentView")
	public RootStructureContentController MobileLayoutRSContentView() {
		RootStructureContentController tbc = new RootStructureContentController();
		tbc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		tbc.addViewDefinition("/mobile/MobileLayoutRSContentView.json");
		return tbc;
	}

	@Bean
	@Named("MobileLayoutRSView")
	public DoubleHeaderRootStructureController MobileLayoutRSView() {
		DoubleHeaderRootStructureController tbc = new DoubleHeaderRootStructureController();
		tbc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		tbc.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		tbc.addViewDefinition("/mobile/MobileLayoutRSView.json");
		return tbc;
	}


	@Bean
	@Named("MobileRootTabPaneView")
	public StandardTabPaneController MobileRootTabPaneView() {
		StandardTabPaneController tbc = new StandardTabPaneController();
		tbc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		tbc.setModelProvider((IModelProvider) Services.getBean("ApplicationRootContainerModelLoader"));
		tbc.setLayoutManager((IViewLayoutManager) Services.getBean("FullTabPaneLayoutManager"));
		tbc.addViewDefinition("/mobile/MobileRootTabPaneView.json");
		return tbc;
	}

	@Bean
	@Named("MobilePrimaryMenuView")
	public PrimaryMenuController PrimaryMenuController() {
		PrimaryMenuController tbc = new PrimaryMenuController();
		tbc.setMessageSource((MessageSource) Services.getBean("RootMessageSource"));
		tbc.setMenuProvider((MenuConfigurationProvider) Services.getBean("MobilePrimaryMenuProvider"));
		tbc.addViewDefinition("/mobile/MobilePrimaryMenuView.json");
		return tbc;
	}

	@Bean
	@Named("MobilePrimaryMenuProvider")
	public PrimaryMenuProvider MobilePrimaryMenuProvider() {
		PrimaryMenuProvider tbc = new PrimaryMenuProvider();
		tbc.setPrimaryMenu("/mobile/MobilePrimaryMenuDefinition.json");
		return tbc;
	}
}
