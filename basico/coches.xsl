<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/coches">
	<html>
	<head>
		<meta charset="utf-8"/>
		<script>
			window.alert("hola");
		</script>
		<style>
			h1 {
				text-align: center;
			}

			table {
				border: 2px dashed black;
				margin-left: auto;
				margin-right: auto;
			}

			th {
				background-color: navy;
				color: white;
			}

			tr:nth-child(odd) {
				background-color: darkgray;
			}

			tr:nth-child(even) {
				background-color: lightgray;
			}
		</style>
	</head>
	<body>
		<h1>Coches</h1>
		<table border="1">	
			<tr>
				<th>Id</th>
				<th>Marca</th>
				<th>Modelo</th>
				<th>Matrícula</th>
				<th>Año</th>
				<th>Dueño</th>
				<th>Accesorios</th>
			</tr>
			<xsl:apply-templates select="coche"/>
		</table>
	</body>
	</html>
</xsl:template>

<xsl:template match="coche">
	<tr>
		<td><xsl:value-of select="@id"/></td>
		<td><xsl:value-of select="marca"/></td>
		<td><xsl:value-of select="modelo"/></td>
		<td><xsl:value-of select="matricula"/></td>
		<td><xsl:value-of select="anio"/></td>
		<td><xsl:apply-templates select="duenio"/></td>
		<td><xsl:apply-templates select="accesorios"/></td>
	</tr>
</xsl:template>

<xsl:template match="duenio">
	<xsl:value-of select="dni"/> -
	<xsl:value-of select="nombre"/><xsl:text> </xsl:text>
	<xsl:value-of select="apellido"/>
</xsl:template>

<xsl:template match="accesorios">
	<table>
		<xsl:for-each select="accesorio">
			<tr>
				<td><xsl:value-of select="nombre"/></td>
				<td>
				<xsl:choose>
					<xsl:when test="tipo != ''">
						<xsl:value-of select="tipo" />
					</xsl:when>
					<xsl:when test="modelo != ''">
						<xsl:value-of select="modelo" />
					</xsl:when>
					<xsl:otherwise>
						N/A
					</xsl:otherwise>
				</xsl:choose>
				</td>
			</tr>
		</xsl:for-each>
	</table>
</xsl:template>

</xsl:stylesheet> 
