/*-
 * #%L
 * Eureka! Clinical User Client
 * %%
 * Copyright (C) 2016 Emory University
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
 * #L%
 */
package org.eurekaclinical.user.client;

import com.sun.jersey.api.client.GenericType;
import java.net.URI;
import java.util.List;
import javax.ws.rs.core.UriBuilder;
import org.eurekaclinical.common.comm.clients.AuthorizingEurekaClinicalClient;
import org.eurekaclinical.common.comm.clients.ClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.eurekaclinical.user.client.comm.OAuthProvider;
import org.eurekaclinical.user.client.comm.PasswordChangeRequest;
import org.eurekaclinical.user.client.comm.User;
import org.eurekaclinical.user.client.comm.UserRequest;

/**
 * EurekaclinicalUserClient is a client that should be used be external
 * applications
 *
 * @author miaoai
 */
public class EurekaClinicalUserClient extends AuthorizingEurekaClinicalClient {

    private static final Logger LOGGER
            = LoggerFactory.getLogger(EurekaClinicalUserClient.class);

    private static final GenericType<List<User>> UserList = new GenericType<List<User>>() {
    };

    private final URI userServiceUrl;

    public EurekaClinicalUserClient(String inUserServiceUrl) {
        super(null);
        this.userServiceUrl = URI.create(inUserServiceUrl);
    }

    @Override
    protected URI getResourceUrl() {
        return this.userServiceUrl;
    }

    @Override
    public List<User> getUsers() throws ClientException {
        final String path = "/api/protected/users";
        return doGet(path, UserList);
    }

    @Override
    public User getMe() throws ClientException {
        String path = "/api/protected/users/me";
        return doGet(path, User.class);
    }

    @Override
    public User getUserById(Long inUserId) throws ClientException {
        final String path = "/api/protected/users/" + inUserId;
        return doGet(path, User.class);
    }

    public void changePassword(String inOldPass, String inNewPass) throws ClientException {
        final String path = "/api/protected/users/passwordchange";
        PasswordChangeRequest passwordChangeRequest
                = new PasswordChangeRequest();
        passwordChangeRequest.setOldPassword(inOldPass);
        passwordChangeRequest.setNewPassword(inNewPass);
        doPost(path, passwordChangeRequest);
    }

    public void updateUser(User inUser, Long userId) throws ClientException {
        final String path = "/api/protected/users/" + userId;
        doPut(path, inUser);
    }

    public void addUser(UserRequest inRequest) throws ClientException {
        final String path = "/api/userrequests";
        doPostCreate(path, inRequest);
    }

    public void verifyUser(String inCode) throws ClientException {
        final String path = "/api/userrequests/verify/" + inCode;
        doPut(path);
    }

    public OAuthProvider getOAuthProvider(Long inId) throws ClientException {
        final String path = "/api/protected/oauthproviders/" + inId;
        return doGet(path, OAuthProvider.class);
    }

    public OAuthProvider getOAuthProviderByName(String inName) throws ClientException {
        final String path = UriBuilder.fromPath("/api/protected/oauthproviders/byname/")
                .segment(inName)
                .build().toString();
        return doGet(path, OAuthProvider.class);
    }
}
