<?xml version="1.0" encoding="ISO-8859-1"?>
<!-- Edited by XMLSpy® -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output method="html"/> 
<xsl:template match="/">
<html>
  <title>HTML REPORTING</title>
    <body>
		<h1 align="center"><xsl:value-of select="//ProjectName"/></h1>
		<table  align="center" width="100%">
			<tr>
				<td align="left" width="50%"><a href="https://google.com"><IMG ALIGN="left" ALT="client" SRC=".\Logos\client_logo.jpg"></IMG></a></td>
				<td align="right" width="50%"><a href="http://www.indiumsoft.com/index.php"><IMG SRC=".\Logos\Indium-Software-Logo.jpg" ALT="Indium Logo" ALIGN="Right "></IMG></a></td>
			</tr>
		</table>
		<br>		</br>
		<table align="left">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td><b>Date:-</b></td>
				<td ><xsl:value-of select="//Date"/></td>
			</tr>
			<tr>
				<td>
					<b>Total Duration:-</b>
				</td>
				<xsl:choose>
					<xsl:when test="round(//suite/@duration-ms div 1000) div 60>'60'">
						<td>
							<xsl:value-of select="round(round((//suite/@duration-ms div 1000) div 60)div 60)"/><xsl:text>hr:</xsl:text><xsl:value-of select="round(round((//suite/@duration-ms div 1000) div 60)mod 60)"/><xsl:text>min:</xsl:text><xsl:value-of select="round((//suite/@duration-ms div 1000) div 60)mod 60"/><xsl:text>sec</xsl:text>
						</td>
					</xsl:when>
					<xsl:when test="round(//suite/@duration-ms div 1000) div 60>'1'">
						<td>
							<xsl:value-of select="round((//suite/@duration-ms div 1000) div 60)"/><xsl:text> Min:</xsl:text><xsl:value-of select="round((//suite/@duration-ms div 1000) mod 60)"/><xsl:text>Sec</xsl:text>
						</td>
					</xsl:when>
					<xsl:otherwise>
						<td>
							<xsl:value-of select="round((//suite/@duration-ms div 1000))"/><xsl:text> Seconds</xsl:text>
						</td>
					</xsl:otherwise>
				</xsl:choose>
			</tr>
			<tr>
				<td>
					<b>Build No:-</b>
				</td>
				<td>
					<xsl:value-of select="//VersionName"/>
				</td>
			</tr>
		</table>
		<!--  <table align="right">
			<tr>
				<td></td>
			</tr>
			<tr>
				<td>
					<b>Start Time:-</b>
				</td>
				<td>
					<xsl:variable name="StartTime" select="//suite/@started-at"/>
					<xsl:value-of select="translate(translate($StartTime,'T',' '),'Z',' ')"/>
				</td>
			</tr>
			<tr>
				<td>
					<b>End Time:-</b>
				</td>
				<td>
					<xsl:variable name="EndTime" select="//suite/@finished-at"/>
					<xsl:value-of select="translate(translate($EndTime,'T',' '),'Z',' ')"/>
				</td>
			</tr>
		</table> -->
		<br>
		<br>
		<br>
		<br>
		</br>
		</br>
		</br>
		</br>
		<TABLE border="1"> 
			<TR> 
				<TD colspan="8"><center><b>TEST CASE EXECUTION STATUS</b></center></TD> 
			</TR> 
			<TR> 
				<TD><b>MACHINE NAME</b></TD>
				<TD><b>OPERATING SYSTEM</b></TD> 
				<TD><b>BROWSER</b></TD> 
				<TD><b>EXECUTED</b></TD> 
				<TD><b>PASSED</b></TD> 
				<TD><b>FAILED</b></TD> 
				<TD><b>SKIPPED</b></TD>	
				<TD><b>DURATION</b></TD>	
			</TR> 
			<xsl:for-each select="//test">
				<xsl:variable name="count" select='position()' />
				<xsl:variable name="Machine" select="//test[$count]//before-method/params/param[@index=0]/value" />
				<xsl:variable name="OS" select="//test[$count]//before-method/params/param[@index=4]/value" />
				<xsl:variable name="OSVersion" select="//test[$count]//before-method/params/param[@index=6]/value" />
				<xsl:variable name="Browser" select="//test[$count]//before-method/params/param[@index=3]/value" />
				<xsl:variable name="BrowserVersion" select="//test[$count]//before-method/params/param[@index=5]/value" />
				<xsl:variable name="CoverPage" select="normalize-space(concat('.\',$Machine,'-',$OS,'(',$OSVersion,')','-',$Browser,'-',$BrowserVersion,'\CoverPage.html'))" />
				<xsl:variable name="path" select="translate(normalize-space($CoverPage),' ' ,'')" />
					<TR>
						<TD><a href='{$path}'><xsl:value-of select="$Machine"/></a></TD> 
						<TD><xsl:value-of select="$OS"/>-<xsl:value-of select="$OSVersion"/></TD> 
						<TD><xsl:value-of select="$Browser"/>-<xsl:value-of select="$BrowserVersion"/></TD> 
						<TD><xsl:value-of select="@totalTest"/></TD> 
						<TD><xsl:value-of select="@totalPassed"/></TD> 
						<TD><xsl:value-of select="@totalFailed"/></TD> 
						<TD><xsl:value-of select="@totalSkipped"/></TD>
						<TD>
							<xsl:choose>
								<xsl:when test="round(@total div 1000) div 60>'59'">
									<xsl:value-of select="round(round((@total div 1000) div 60)div 60)"/><xsl:text>hr:</xsl:text><xsl:value-of select="round((@total div 1000) div 60)mod 60"/><xsl:text>min:</xsl:text><xsl:value-of select="round((@total div 1000) div 60)mod 60"/><xsl:text>sec</xsl:text>
								</xsl:when>
								<xsl:when test="round(@total div 1000) div 60>'1'">
									<xsl:value-of select="round((@total div 1000) div 60)"/><xsl:text> Min:</xsl:text><xsl:value-of select="round((@total div 1000) mod 60)"/><xsl:text>Sec</xsl:text>
								</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="round((@total div 1000))"/><xsl:text> Seconds</xsl:text>
							</xsl:otherwise>
							</xsl:choose>
						</TD>
					</TR>
			</xsl:for-each>
		</TABLE>
    </body>     
</html>
</xsl:template>
</xsl:stylesheet>

