/*-
 * ========================LICENSE_START=================================
 * JSoagger
 * %%
 * Copyright (C) 2019 JSOAGGER
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

package io.github.jsoagger.tafaresaka.beanproviders.mobile.action;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

import io.github.jsoagger.core.bridge.operation.IOperationResult;
import io.github.jsoagger.core.bridge.operation.JsonUtils;
import io.github.jsoagger.core.bridge.result.OperationData;
import io.github.jsoagger.core.bridge.result.SingleResult;
import io.github.jsoagger.core.business.cloud.services.utils.CloudServicesLocator;
import io.github.jsoagger.jfxcore.api.security.ILoginSessionHolder;
import io.github.jsoagger.jfxcore.api.security.RootContextMode;
import io.github.jsoagger.jfxcore.api.services.Services;
import io.github.jsoagger.jfxcore.engine.controller.main.layout.ViewStructure;
import io.github.jsoagger.jfxcore.engine.events.LoginSuccessEvent;

/**
 * When user has logged in, a session id is sent to the server. This session id
 * is unique along the application. Singleton in spring context.
 *
 * @author Ramilafananana Vonjisoa
 * @mailTo yvonjisoa@nexitia.com
 * @date 23 janv. 2018
 */
public class LocalStorage implements ILoginSessionHolder {

	private static LocalStorage instance = new LocalStorage();

	private String sessionId;
	private IOperationResult loginResult;
	private RootContextMode mode = RootContextMode.Anonymous;
	private Map<Object, Object> cache = new HashMap<Object, Object>();

	private JsonObject applicationContainer = null;
	private JsonObject workingContainer = null;
	private JsonObject userAccountOwner = null;
	private JsonObject useraccount = null;
	private String homePageCatalogId = null;

	/**
	 * Default Constructor
	 */
	private LocalStorage() {
	}

	public static synchronized LocalStorage instance() {
		return instance;
	}

	public JsonObject userDetails() {
		return userAccountOwner;
	}

	public JsonObject userAccount() {
		return useraccount;
	}

	/**
	 * ---------------------------------------------------------------------------------
	 *
	 * MISC
	 *
	 * ---------------------------------------------------------------------------------
	 */
	private SingleResult getContainerByPath(String path) {
		JsonObject query = new JsonObject();
		query.addProperty("path", "/Application");
		return (SingleResult) CloudServicesLocator.getContainerApi().getContainerByPath(query);
	}

	public String getWorkingContainerOwnerId() {
		return workingContainer.get("containerOwnerId").getAsString();
	}

	SingleResult applicationContainer2 = null;

	public String getWorkingContainerId() {
		if (workingContainer == null) {
			// before the authentication, some data may be needed but
			// user is not connected yet!!
			applicationContainer2 = getContainerByPath("/Application");
			return (String) applicationContainer2.getData().getAttributes().get("id");
		}
		return (String) workingContainer.get("id").getAsString();
	}

	public String getWorkingContainerName() {
		if(workingContainer == null) {
			return "Application";
		}

		return (String) workingContainer.get("name").getAsString();
	}

	public String getUserAccountOwnerId() {
		return userAccountOwner.get("id").getAsString();
	}

	public String getUserAccountId() {
		if (instance.useraccount == null) {
			throw new RuntimeException("Inconsistent context, no user account!");
		}
		return instance.useraccount.get("id").getAsString();
	}

	public void cachePut(Object key, Object value) {
		cache.put(key, value);
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	@Override
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public IOperationResult getLoginResult() {
		return loginResult;
	}

	@Override
	public void setLoginResult(IOperationResult loginResult) {
		this.loginResult = loginResult;
		instance.processLoginResult();
	}

	@Override
	public RootContextMode getMode() {
		return mode;
	}

	@Override
	public void setMode(RootContextMode mode) {
		this.mode = mode;
	}

	/**
	 * @return the cache
	 */
	public Map<Object, Object> getCache() {
		return cache;
	}

	/**
	 * @param cache the cache to set
	 */
	public void setCache(Map<Object, Object> cache) {
		this.cache = cache;
	}

	@Override
	public String toString() {
		return "LoginSessionHolder [sessionId=" + sessionId + ", cache=" + cache + ", applicationContainer="
				+ applicationContainer + ", workingContainer=" + workingContainer + ", userAccountOwner="
				+ userAccountOwner + ", useraccount=" + useraccount + "]";
	}

	private void processLoginResult() {
		String uao = (String) ((SingleResult) loginResult).getData().getLinks().get("user");
		userAccountOwner = JsonUtils.toJsonObject(uao);

		String ua = (String) ((SingleResult) loginResult).getData().getLinks().get("account");
		useraccount = JsonUtils.toJsonObject(ua);

		String workingContainerString = (String) ((SingleResult) loginResult).getData().getLinks().get("container");
		workingContainer = JsonUtils.toJsonObject(workingContainerString);

		String ac = (String) ((SingleResult) loginResult).getData().getLinks().get("applicationContainer");
		applicationContainer = JsonUtils.toJsonObject(ac);
	}

	public void switchToContainer(OperationData data) {
		workingContainer.addProperty("id", (String) data.getAttributes().get("id"));
		workingContainer.addProperty("name", (String) data.getAttributes().get("name"));

		LoginSuccessEvent loginSuccessEvent = new LoginSuccessEvent();
		Services.dispatchEvent(loginSuccessEvent);
		ViewStructure.instance().listenTo(loginSuccessEvent);
	}

	@Override
	public void logout() {
		this.sessionId = null;
		instance = new LocalStorage();
		workingContainer = null;
	}
}
