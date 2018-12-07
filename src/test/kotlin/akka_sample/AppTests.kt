package akka_sample

import akka.http.javadsl.testkit.JUnitRouteTest
import akka.http.javadsl.testkit.TestRoute
import akka.http.javadsl.model.HttpRequest
import org.junit.Test
import kotlin.test.assertEquals

class AppTests : JUnitRouteTest() {

    private val appRoute : TestRoute = testRoute(App.route())

    @Test
    fun getHelloShouldReturn200() {
        val res = appRoute.run(HttpRequest.GET("/hello"))
        res.assertStatusCode(200)
    }
}
