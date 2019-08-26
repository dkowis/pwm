/*
 * Password Management Servlets (PWM)
 * http://www.pwm-project.org
 *
 * Copyright (c) 2006-2009 Novell, Inc.
 * Copyright (c) 2009-2019 The PWM Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package password.pwm.config.value.data;

import password.pwm.PwmConstants;

import java.io.Serializable;

public class UserPermission implements Serializable
{
    public enum Type
    {
        ldapQuery,
        ldapGroup,
    }

    private String ldapProfileID = PwmConstants.PROFILE_ID_ALL;
    private String ldapQuery;
    private String ldapBase;
    private Type type;

    public UserPermission(
            final Type type,
            final String ldapProfileID,
            final String ldapQuery,
            final String ldapBase
    )
    {
        this.type = type;
        this.ldapProfileID = ldapProfileID;
        this.ldapQuery = ldapQuery;
        this.ldapBase = ldapBase;
    }

    public String getLdapProfileID( )
    {
        return ldapProfileID == null ? null : ldapProfileID.trim();
    }

    public String getLdapQuery( )
    {
        return ldapQuery;
    }

    public String getLdapBase( )
    {
        return ldapBase;
    }

    public Type getType( )
    {
        return type == null ? Type.ldapQuery : type;
    }
}
