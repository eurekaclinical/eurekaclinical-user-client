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

import org.eurekaclinical.user.client.comm.authentication.LoginType;
/**
 *
 * @author miaoai
 */
public final class LdapUserRequest extends UserRequest {

    public LdapUserRequest() {
        setLoginType(LoginType.INTERNAL);
    }

    @Override
    public void accept(UserRequestVisitor userRequestVisitor) {
        userRequestVisitor.visit(this);
    }

    @Override
    public org.eurekaclinical.user.client.comm.authentication.AuthenticationMethod authenticationMethod() {
        return org.eurekaclinical.user.client.comm.authentication.AuthenticationMethod.LDAP;
    }

}
