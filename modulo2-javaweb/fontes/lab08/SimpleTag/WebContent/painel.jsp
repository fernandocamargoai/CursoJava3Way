<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Exemplo JSP 2.0 - Painéis usando Tag File</title>
</head>
<body>
	<h1>Exemplo JSP 2.0 - Painéis usando Tag File</h1>
	<hr>
	<table border="0">
		<tr valign="top">
			<td>
				<tags:painel cor="#ff8080" corfundo="#ffc0c0" titulo="Painel 01" subtitulo="JSP">
					Primeiro Painel<br/>
				</tags:painel>
			</td>
			<td>
				<tags:painel cor="#80ff80" corfundo="#c0ffc0" titulo="Painel 02" subtitulo="2.0">
					Segundo Painel.<br/>
					Segundo Painel.<br/>
					Segundo Painel.<br/>
					Segundo Painel.<br/>
				</tags:painel>
			</td>
			<td>
				<tags:painel cor="#8080ff" corfundo="#c0c0ff" titulo="Painel 03" subtitulo="Tag">
					Terceiro Paienl.<br/>
					<tags:painel cor="#ff80ff" corfundo="#ffc0ff" titulo="Incluso" subtitulo="File">
						Um Painel dentro de outro painel.
					</tags:painel>
					Terceiro Painel.<br/>
				</tags:painel>
			</td>
			<td>
				<tags:painel cor="#8000ff" corfundo="c0c0ff" titulo="Painel 4" subtitulo="no">
					Quarto Painel.<br/>
					<tags:painel cor="#ff8000" corfundo="ffc0ff" titulo="Incluso" subtitulo="Painel">
						Um Painel dentro de outro painel.<br/>
						<tags:painel cor="#ff8000" corfundo="#ffc0ff" titulo="Incluso no Incluso">
							Um Painel dentro de outro painel que está dentro de outro painel.<br/>
						</tags:painel>
					</tags:painel>
					Quarto Painel.<br/>
				</tags:painel>
			</td>
		</tr>
	</table>
</body>
</html>