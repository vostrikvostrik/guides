<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" import="java.io.PrintWriter"%>
<%@ page import="java.io.StringWriter" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>Error 500</h2>
<div class="errorDiv" style="padding:10px;">
    <b>URL:</b> ${pageContext.errorData.requestURI} <br />
    <b>Status code:</b> ${pageContext.errorData.statusCode} <br />
    <b>Exception:</b> ${pageContext.errorData.throwable}
    <br/>
    <p><b>Params:</b>
    <ol>
        <%
            Map<String, String[]> parameters = request.getParameterMap();
            for(String parameter : parameters.keySet()) {
                String[] values = parameters.get(parameter);%>
        <li><%=parameter %> : <% for(String val :values){ out.print("[" + val + "]"); } %></li>
        <%
            }
        %>
    </ol>
    </p>
    <div id="stacktraceDiv">
        <%
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            pageContext.getErrorData().getThrowable().printStackTrace(pw);
            out.print(sw.toString().replaceAll("\n", "<br/>"));
            sw.close();
            pw.close();
        %>
    </div>
</div>

