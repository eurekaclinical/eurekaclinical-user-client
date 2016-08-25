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
package org.eurekaclinical.user.client.comm;

import org.eurekaclinical.user.client.comm.authentication.AuthenticationMethod;
import org.eurekaclinical.user.client.comm.authentication.LoginType;
/**
 *
 * @author miaoai
 */
public final class OAuthUserRequest extends UserRequest {

    private String providerUsername;
    private String oauthProvider;

    public OAuthUserRequest() {
        setLoginType(LoginType.PROVIDER);
    }

    public String getProviderUsername() {
        return providerUsername;
    }

    public void setProviderUsername(String providerUsername) {
        this.providerUsername = providerUsername;
    }

    public String getOAuthProvider() {
        return oauthProvider;
    }

    public void setOAuthProvider(String oauthProvider) {
        this.oauthProvider = oauthProvider;
    }

    @Override
    public String[] validate() {
        String[] results = super.validate();

        if (this.oauthProvider == null) {
            String[] newResults = new String[results.length + 1];
            System.arraycopy(results, 0, newResults, 0, results.length);
            newResults[results.length] = "OAuth provider unspecified";
            results = newResults;
        }
        return results;
    }

    @Override
    public void accept(UserRequestVisitor userRequestVisitor) {
        userRequestVisitor.visit(this);
    }

    @Override
    public AuthenticationMethod authenticationMethod() {
        return AuthenticationMethod.OAUTH;
    }

}
