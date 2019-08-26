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

package password.pwm.svc.cache;

import password.pwm.error.PwmUnrecoverableException;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public interface CacheStore
{
    void store( CacheKey cacheKey, Instant expirationDate, Serializable data ) throws PwmUnrecoverableException;

    <T extends Serializable> T readAndStore( CacheKey cacheKey, Instant expirationDate, Class<T> classOfT, CacheLoader<T> cacheLoader )
            throws PwmUnrecoverableException;

    <T extends Serializable> T read( CacheKey cacheKey, Class<T> classOfT ) throws PwmUnrecoverableException;

    CacheStoreInfo getCacheStoreInfo( );

    int itemCount( );

    List<CacheDebugItem> getCacheDebugItems( );

    long byteCount();
}
