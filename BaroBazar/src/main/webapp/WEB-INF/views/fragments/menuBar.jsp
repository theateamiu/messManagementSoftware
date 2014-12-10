<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header">
	<ul class="nav nav-tabs">
		<li <% if(request.getRequestURI().contains("home")) {%> class="active" <%}%>>
			<a href="<c:url value="/home"/>">Home</a>
		</li>
		<li <% if(request.getRequestURI().contains("mess")) {%> class="active" <%}%>>
			<a href="<c:url value="/mess"/>">Mess</a>
		</li>
		<li <% if(request.getRequestURI().contains("bazaar")) {%> class="active" <%}%>>
			<a href="<c:url value="/bazaar"/>">Bazaar</a>
		</li>
		<li <% if(request.getRequestURI().contains("contributors")) {%> class="active" <%}%>>
			<a href="<c:url value="/contributors" />">Contributors</a>
		</li>
	</ul>
</div>