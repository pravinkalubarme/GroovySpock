package demotest

import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import static io.restassured.RestAssured.*
import spock.lang.Specification

class PostRequest extends Specification {

    def setup()
    {
        given:
        RestAssured.baseURI=Payload.baseURI()
    }
    def "POST Request: To create user valid deatils"()
    {
        given:
        def response=given().body(Payload.bodyToPost("Pravin", "QA")).post("api/users")
        expect:
        response.statusCode()==201
    }

   def "POST Request: To create user with another valid user"()
    {
        given:
        def response=given().body(Payload.bodyToPost("PravinKalubarme", "QA")).post("api/users")
        expect:
        response.statusCode()==201
    }

    def "POST Request: To create user with no user data"()
    {
        given:
        def response=given().post("api/users")
        expect:
        response.statusCode()!=201
    }

    def "POST Request: To create user with invalid resource"()
    {
        given:
        def response=given().body(Payload.bodyToPost("PravinKalubarme", "QA Auto")).post("aapi/users")
        expect:
        response.statusCode()==404
    }
}
