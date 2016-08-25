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
import java.util.Date;

/**
 *
 * @author miaoai
 */
public final class LocalUser extends User {

    private boolean verified;
    private String verificationCode;
    private String password;
    private Date passwordExpiration;

    public LocalUser() {
        setLoginType(LoginType.INTERNAL);
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean inVerified) {
        verified = inVerified;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String inVerificationCode) {
        verificationCode = inVerificationCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String inPassword) {
        password = inPassword;
    }

    public Date getPasswordExpiration() {
        return passwordExpiration;
    }

    public void setPasswordExpiration(Date inPasswordExpiration) {
        passwordExpiration = inPasswordExpiration;
    }

    @Override
    public String[] validate() {
        String[] results = super.validate();
        PasswordValidator passwordValidator = new PasswordValidator();
        if (!passwordValidator.validate(this.password)) {
            String[] newResults = new String[results.length + 1];
            System.arraycopy(results, 0, newResults, 0, results.length);
            newResults[results.length] = "Password must be at least 8 characters long.";
            results = newResults;
        }
        return results;
    }

    @Override
    public void accept(UserVisitor userVisitor) {
        userVisitor.visit(this);
    }

    @Override
    public AuthenticationMethod authenticationMethod() {
        return AuthenticationMethod.LOCAL;
    }

}
