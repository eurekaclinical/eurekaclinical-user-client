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
public class AuthenticationMethod {

    private Long id;

    private org.eurekaclinical.user.client.comm.authentication.AuthenticationMethod name;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public org.eurekaclinical.user.client.comm.authentication.AuthenticationMethod getName() {
        return name;
    }

    public void setName(org.eurekaclinical.user.client.comm.authentication.AuthenticationMethod name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "AuthenticationMethod{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
    
}
