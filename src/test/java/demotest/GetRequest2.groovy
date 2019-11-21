package demotest
import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import static io.restassured.RestAssured.expect
import static io.restassured.RestAssured.given
import spock.lang.Specification

class GetRequest2 extends Specification{


    def "GET Request to get list of user"()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        def resp=given().queryParam("page","2").get("api/users");
        expect:
        def j= new JsonPath(resp.asString())
        for (int i = 0; i < 5; i++)
        {
            println j.get("data["+i+"].first_name")
        }
        println(resp.asString());
        resp.statusCode()==200
    }
}
