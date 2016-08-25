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
/**
 *
 * @author miaoai
 */
public interface UserVisitor {
	
	/**
	 * Processes a local user entity.
	 * @param localUser a local user. Cannot be <code>null</code>.
	 */
	void visit(LocalUser localUser);
	
	/**
	 * Processes an LDAP user entity.
	 * @param ldapUser an LDAP user. Cannot be <code>null</code>.
	 */
	void visit(LdapUser ldapUser);
	
	/**
	 * Processes an OAuth user entity.
	 * @param oauthUser an OAuth user. Cannot be <code>null</code>.
	 */
	void visit(OAuthUser oauthUser);
}
