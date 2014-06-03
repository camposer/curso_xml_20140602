<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fn="http://www.w3.org/2005/xpath-functions">
	<xsl:output method="html"/><!-- Valor por defecto -->
	<xsl:template match="/ordenadores">
		<html>
			<head>
				<meta charset="utf-8"/>
			</head>
			<body>
				<h1>Ordenadores</h1>
				<table>
					<tr>
						<th>Id</th>
						<th>Nombre</th>
						<th>Serial</th>
						<th>Dueño</th>
					</tr>
					<xsl:apply-templates select="ordenador"/>
				</table>
			</body>
		</html>
	</xsl:template>

	<xsl:template match="ordenador">
		<tr>
			<td><xsl:value-of select="././@id"/></td>
			<td><xsl:value-of select="nombre"/></td>
			<td><xsl:value-of select="serial"/></td>
			<td><xsl:apply-templates select="persona"/></td>
		</tr>
	</xsl:template>

	<xsl:template match="persona">
		<xsl:variable name="fecha" select="fechaNacimiento"/>
		<ul>
			<li><xsl:value-of select="nombre"/></li>
			<li><xsl:value-of select="apellido"/></li>
			<li><xsl:copy-of select="replace($fecha, '-', '/')" /></li>
			<li><xsl:value-of select="altura"/></li>
		</ul>
	</xsl:template>

</xsl:stylesheet> 
