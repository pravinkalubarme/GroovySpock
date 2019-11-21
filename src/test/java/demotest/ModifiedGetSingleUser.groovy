package demotest
import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import org.apache.poi.ss.usermodel.WorkbookFactory
import spock.lang.Specification
import static io.restassured.RestAssured.given
//import org.apache.poi.xssf.usermodel.XSSFWorkbook
class ModifiedGetSingleUser extends Specification {
    def "GET Resquest to get details of single user"()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        def resp=given().get("api/users/2");
      //  File file =    new File("C:\\Users\\pravi\\Desktop\\1Single User.xls");
        FileInputStream fis= new FileInputStream(file);
        def rownum = new HSSFWorkbook(fis).getSheet("Sheet1").getLastRowNum()
        println("No of rows=" +romnum)
//       def sheet=WorkbookFactory.create(fis).getSheet("Sheet1");
//       def id=sheet.getRow(1).getCell(0).getNumericCellValue();
    //    println("ID from Excel sheet: "+id)
        expect:
        println("ID from Excel sheet: "+id)
        def j= new JsonPath(resp.asString())
        resp.statusCode()==200
        j.get("data.id")==2
    }
}
