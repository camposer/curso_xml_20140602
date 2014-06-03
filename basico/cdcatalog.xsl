<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>My CD Collection</h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th>Title</th>
      <th>Artist</th>
    </tr>

	<xsl:apply-templates select="catalog/cd"/>
  </table>
  </body>
  </html>
</xsl:template>

<xsl:template match="catalog/cd">
    <tr>
      <td><xsl:value-of select="title"/></td>
      <xsl:choose>
        <xsl:when test="price &gt; 10">
			<xsl:apply-templates select="artist"/>
        </xsl:when>
        <xsl:otherwise>
          <td><xsl:value-of select="artist"/></td>
        </xsl:otherwise>
      </xsl:choose>
    </tr>
</xsl:template>

<xsl:template match="artist">
          <td bgcolor="#ff0000">
          <xsl:value-of select="."/></td>
</xsl:template>

</xsl:stylesheet> 
