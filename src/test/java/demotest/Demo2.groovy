package demotest
import io.restassured.RestAssured
import io.restassured.path.json.JsonPath
import static io.restassured.RestAssured.*
import spock.lang.Specification

class Demo2 extends Specification{
   def "getRequest"() {
       given: "Base URL"
       RestAssured.baseURI="https://reqres.in/"
       def resp=given().get("api/users/2")

       expect:
       resp.then().assertThat().statusCode(200)
       def response=resp.asString()
       println resp.statusCode();
       println(resp.asString())
       JsonPath js= new JsonPath(resp.asString())
       def id=js.get("data.id")
       print(id)
   }
}
