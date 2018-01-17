/*
 * This program is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License, version 2 as published by the Free Software
 * Foundation.
 *
 * You should have received a copy of the GNU General Public License along with this
 * program; if not, you can obtain a copy at http://www.gnu.org/licenses/gpl-2.0.html
 * or from the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 *
 *
 * Copyright 2006 - 2018 Hitachi Vantara.  All rights reserved.
 */

package org.pentaho.platform.engine.core.system;

import org.pentaho.platform.api.engine.IPentahoRequestContext;

public class BasePentahoRequestContext implements IPentahoRequestContext {

  public String contextPath;
  public static final String SLASH = "/";
  public static final String EMPTY = "";

  public BasePentahoRequestContext( String contextPath ) {
    super();
    if ( contextPath != null ) {
      String draftPath = contextPath + ( contextPath.endsWith( SLASH ) ? EMPTY : SLASH );
      this.contextPath = draftPath.replaceAll( "(?<!^http:)(/){2,}", SLASH );
    } else {
      String path = PentahoSystem.getApplicationContext().getFullyQualifiedServerURL();
      this.contextPath = path + ( path != null && path.endsWith( SLASH ) ? EMPTY : SLASH );
    }
  }

  public String getContextPath() {
    return contextPath;
  }
}
