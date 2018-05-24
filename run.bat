set path=%path%;.\sikuli-ide\libs
javac -d bin -sourcepath src -cp .\ext\selenium-server-standalone-2.48.2.jar;.\ext\jtidy-r872-jdk15.jar;.\ext\jxl.jar;.\ext\log4j-1.2.16.jar;.\ext\mail.jar;.\ext\java-client-1.7.0.jar;.\ext\gson-2.2.4.jar;.\ext\activation.jar;.\ext\itextpdf-5.2.1.jar;.\ext\ezmorph-1.0.jar;.\ext\couchdb4j-0.1.2.jar;.\ext\apache-commons-lang.jar;.\ext\json-lib.jar;.\ext\json-simple-1.1.1.jar;.\ext\org.apache.commons.beanutils.jar;.\ext\org.apache.commons.httpclient.jar;.\ext\postgresql-9.4-1201.jdbc4.jar .\src\iSAFE\TestDriver.java


java -cp bin;.\ext\selenium-server-standalone-2.48.2.jar;.\ext\jtidy-r872-jdk15.jar;.\ext\jxl.jar;.\ext\log4j-1.2.16.jar;.\ext\mail.jar;.\ext\java-client-1.7.0.jar;.\ext\gson-2.2.4.jar;.\ext\activation.jar;.\ext\itextpdf-5.2.1.jar;.\ext\ezmorph-1.0.jar;.\ext\couchdb4j-0.1.2.jar;.\ext\apache-commons-lang.jar;.\ext\json-lib.jar;.\ext\json-simple-1.1.1.jar;.\ext\org.apache.commons.beanutils.jar;.\ext\org.apache.commons.httpclient.jar;.\ext\postgresql-9.4-1201.jdbc4.jar iSAFE.TestDriver

pause