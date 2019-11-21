package demotest

class Payload {
    def static bodyToPost(String name, String job) {
        String body = "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"job\": \"" + job + "\"\n" +
                "}"
        return body
    }

    def static baseURI() {
        String baseURI = "https://reqres.in/"
        return baseURI
    }

}