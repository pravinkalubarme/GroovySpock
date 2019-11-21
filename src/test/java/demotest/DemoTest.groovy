package demotest

import org.junit.Test
import spock.lang.*;
import org.codehaus.groovy.scriptom.*

class DemoTest extends Specification {
    // @Test
    void "demo"() {
        given:
        print("A")
        def a = 10;

        expect:
        a == 10;
    }
}
