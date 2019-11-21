package demotest

import spock.lang.Specification
import io.restassured.RestAssured
import spock.lang.Unroll

import static io.restassured.RestAssured.given
import io.restassured.path.json.JsonPath

class GetRequestSingleUser extends Specification{

    def "GET Resquest: user with correct id and correct name"()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        def resp=given().get("api/users/2");
        expect:
        def j= new JsonPath(resp.asString())
        resp.statusCode()==200
        j.get("data.id")==2
        j.get("data.first_name")=="Janet"
    }

    def "GET Resquest: user with correct id and wrong name"()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        def resp=given().get("api/users/2");
        expect:
        def j= new JsonPath(resp.asString())
        resp.statusCode()==200
        j.get("data.id")==2
        j.get("data.first_name")=="Pravin"
    }

    def "GET Resquest: user with wrong id and correct name"()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        def resp=given().get("api/users/2");
        expect:
        def j= new JsonPath(resp.asString())
        resp.statusCode()==200
        j.get("data.id")==3
        j.get("data.first_name")=="Janet"
    }
    def "GET Resquest: user with wrong id and wrong name"()
    {
        given:
        RestAssured.baseURI="https://reqres.in/"
        def resp=given().get("api/users/2");
        expect:
        def j= new JsonPath(resp.asString())
        resp.statusCode()==200
        j.get("data.id")==3
        j.get("data.first_name")=="Pravin"
    }

}
