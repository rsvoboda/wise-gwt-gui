/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.wise.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.jboss.wise.core.exception.WiseAuthenticationException;
import org.jboss.wise.core.exception.WiseProcessingException;
import org.jboss.wise.core.exception.WiseURLException;
import org.jboss.wise.core.exception.WiseWebServiceException;
import org.jboss.wise.gwt.shared.Service;
import org.jboss.wise.gwt.shared.WsdlAddress;
import org.jboss.wise.gwt.shared.WsdlInfo;
import org.jboss.wise.gwt.shared.tree.element.RequestResponse;
import org.jboss.wise.gwt.shared.tree.element.TreeElement;

import java.util.ArrayList;
import java.util.List;

/**
 * User: rsearls
 * Date: 3/8/15
 */
@RemoteServiceRelativePath("mainService") public interface MainService extends RemoteService {
    ArrayList<WsdlAddress> getAddressDetails();

    List<Service> getEndpoints(WsdlInfo wsdlInfo) throws WiseProcessingException;

    RequestResponse getEndpointReflection(String id);

    String getRequestPreview(TreeElement rootTreeElement);

    RequestResponse getPerformInvocationOutputTree(TreeElement rootTreeElement, WsdlInfo wsdlInfo)
            throws WiseWebServiceException, WiseProcessingException, WiseAuthenticationException;

    boolean isValidURL(String url) throws WiseURLException;
}
