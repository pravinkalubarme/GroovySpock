package Tweeter

import io.restassured.RestAssured
import static io.restassured.RestAssured.*
import spock.lang.Specification

class ToTweet extends Specification
{
    def consumerKey
    def consumerSecretKey
    def accessToken
    def accessTokenSecret
    def setup(){
        Properties pro = new Properties()
        FileInputStream fis= new FileInputStream("C:\\Users\\pravi\\IdeaProjects\\GroovySpock\\src\\test\\java\\Tweeter\\properties")
        pro.load(fis);
        RestAssured.baseURI=pro.getProperty("RestAssured.baseURI")
        consumerKey=pro.getProperty("consumerKey")
        consumerSecretKey=pro.getProperty("consumerSecretKey")
        accessTokenSecret=pro.getProperty("accessTokenSecret")
        accessToken=pro.getProperty("accessToken")
        println("consumerSecretKey: "+consumerSecretKey)
        println("consumerKey: "+consumerKey)
        println("accessToken: "+accessToken)
        println("accessTokenSecret: "+accessTokenSecret)
    }
    def "Method to make tweet"() {
      given:
            println("Given OK")
        def authentication=given().auth().oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
      println("Given OK")
        def res=authentication.formParam("status","My next Tweet from RESTAPI at 16.56").post("/update.json")
         println("Given OK")

      expect:
            println("Expect OK")
        println ("Actal Response is :"+res.asString())
    }
}
