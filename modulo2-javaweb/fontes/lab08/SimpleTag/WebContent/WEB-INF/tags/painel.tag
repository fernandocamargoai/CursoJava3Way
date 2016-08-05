<%@ attribute name="cor" %>
<%@ attribute name="corfundo" %>
<%@ attribute name= "titulo"%>
<%@ attribute name= "subtitulo" %>
<table border="1" bgcolor="${cor}">
	<tr>
		<td><b>${titulo} <u>${subtitulo}</u></b></td>
	</tr>
	<tr>
		<td bgcolor="${corfundo}">
			<jsp:doBody/>
		</td>
	</tr>
</table>