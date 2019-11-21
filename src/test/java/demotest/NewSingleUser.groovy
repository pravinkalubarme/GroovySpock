package demotest

import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import spock.lang.Specification
import static io.restassured.RestAssured.given

class NewSingleUser extends Specification{
    def response
    def json
    def setup()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
    }

    def "GET Resquest: If Resource is valid and id is valid"()
    {   given:
            response=given().get("api/users/2");
            json= new JsonPath(response.asString())
         expect:
            response.statusCode()==200
            json.get("data.id")==2
            json.get("data.first_name")=="Janet"
    }

    def "GET Resquest: If resource is valid and id is invalid"()
    {   given:
            response=given().get("api/users/13");
            json= new JsonPath(response.asString())
        expect:
            response.statusCode()==404
            json.get("data.first_name")== null
            json.get("data.id")== null
    }
    def "GET Resquest: If Resource is invalid and id is valid"()
    {   given:
        response=given().get("aapi/users/2")
        expect:
        response.statusCode()==404
    }

    def "GET Resquest: If Resource is invalid and id is invalid"()
    {   given:
    response=given().get("aapi/users/13")
        expect:
        response.statusCode()==404
    }

    def "GET Resquest: If No Resource"()
    {   given:
        response=given().get()
        expect:
        response.statusCode()==200
    }
}