package demotest
import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import org.apache.poi.hssf.usermodel.HSSFWorkbook
import spock.lang.Specification
import org.apache.poi.ss.usermodel.Workbook
import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.given
import static io.restassured.RestAssured.given

class SingleUser extends Specification{
    def resp
    def j
    def setup()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        resp=given().get("api/users/2");
        j= new JsonPath(resp.asString())
    }

    def "GET Resquest: user with correct id and correct name"()
    {
        expect:
        resp.statusCode()==200
        j.get("data.id")==2
        j.get("data.first_name")=="Janet"
    }

    def "GET Resquest: user with correct id and wrong name"()
    {   expect:
        resp.statusCode()==200
        j.get("data.id")==2
        j.get("data.first_name")!="Pravin"
    }

    def "GET Resquest: user with wrong id and correct name"()
    {   expect:
        resp.statusCode()==200
        j.get("data.id")!=3
        j.get("data.first_name")=="Janet"
    }
    def "GET Resquest: user with wrong id and wrong name"()
    {   expect:
        resp.statusCode()==200
        j.get("data.id")!=3
        j.get("data.first_name")!="Pravin"
    }
}