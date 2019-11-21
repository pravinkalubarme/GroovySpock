package demotest

import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import spock.lang.Specification
import static io.restassured.RestAssured.given

class NewSuperClass extends Specification{
    def response
    def json
    def setup()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        response=given().get("api/users/2");
        json= new JsonPath(response.asString())
    }

    def "GET Resquest: user with correct id and correct name"()
    {
        expect:
           response.statusCode()==200
           json.get("data.id")==2
           json.get("data.first_name")=="Janet"
    }

    def "GET Resquest: user with correct id and wrong name"()
    {   expect:
           response.statusCode()==200
           json.get("data.id")==2
           json.get("data.first_name")!="Pravin"
    }

    def "GET Resquest: user with wrong id and correct name"()
    {   expect:
           response.statusCode()==200
           json.get("data.id")!=3
           json.get("data.first_name")=="Janet"
    }
    def "GET Resquest: user with wrong id and wrong name"()
    {   expect:
           response.statusCode()==200
           json.get("data.id")!=3
           json.get("data.first_name")!="Pravin"
    }
}
