/*
 * Password Management Servlets (PWM)
 * http://www.pwm-project.org
 *
 * Copyright (c) 2006-2009 Novell, Inc.
 * Copyright (c) 2009-2017 The PWM Project
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package password.pwm.http.client;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;

public class PwmHttpClientResponse implements Serializable {
    private final int statusCode;
    private final String statusPhrase;
    private final Map<String,String> headers;
    private final String body;

    public PwmHttpClientResponse(final int statusCode, final String statusPhrase, final Map<String, String> headers, final String body) {
        this.statusCode = statusCode;
        this.statusPhrase = statusPhrase;
        this.headers = headers == null
                ? Collections.emptyMap()
                : Collections.unmodifiableMap(headers);
        this.body = body;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusPhrase() {
        return statusPhrase;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }

    public String toDebugString() {
        return PwmHttpClient.entityToDebugString("HTTP response status " + statusCode + " " + statusPhrase, headers, body);
    }

}
