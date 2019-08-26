<%--
 ~ Password Management Servlets (PWM)
 ~ http://www.pwm-project.org
 ~
 ~ Copyright (c) 2006-2009 Novell, Inc.
 ~ Copyright (c) 2009-2019 The PWM Project
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
--%>


<%@ page import="password.pwm.http.JspUtility" %>
<%@ page import="password.pwm.http.tag.conditional.PwmIfTest" %>
<%@ page import="password.pwm.http.bean.GuestRegistrationBean" %>
<%@ page import="password.pwm.http.servlet.GuestRegistrationServlet" %>

<%@ taglib uri="pwm" prefix="pwm" %>
<%
    final GuestRegistrationBean guestBean = JspUtility.getSessionBean(pageContext, GuestRegistrationBean.class);
    final GuestRegistrationServlet.Page currentPage = guestBean.getCurrentPage();
%>
<br/>
<div style="text-align: center">
    <% boolean selected = currentPage == GuestRegistrationServlet.Page.create; %>
    <form action="<pwm:current-url/>" method="post" enctype="application/x-www-form-urlencoded" id="dashboard" name="dashboard">
        <button type="submit" class="navbutton<%=selected?" selected":""%>">
            <pwm:if test="<%=PwmIfTest.showIcons%>"><span class="btn-icon pwm-icon pwm-icon-user-plus"></span></pwm:if>
            <pwm:display key="Title_GuestRegistration"/>
        </button>
        <input type="hidden" name="pwmFormID" value="<pwm:FormID/>"/>
        <input type="hidden" name="processAction" value="selectPage"/>
        <input type="hidden" name="page" value="create"/>
    </form>
    <% selected = currentPage == GuestRegistrationServlet.Page.search; %>
    <form action="<pwm:current-url/>" method="post" enctype="application/x-www-form-urlencoded" id="activity" name="activity">
        <button type="submit" class="navbutton<%=selected?" selected":""%>">
            <pwm:if test="<%=PwmIfTest.showIcons%>"><span class="btn-icon pwm-icon pwm-icon-calendar"></span></pwm:if>
            <pwm:display key="Title_GuestUpdate"/>
        </button>
        <input type="hidden" name="pwmFormID" value="<pwm:FormID/>"/>
        <input type="hidden" name="processAction" value="selectPage"/>
        <input type="hidden" name="page" value="search"/>
    </form>
</div>
<br/>
