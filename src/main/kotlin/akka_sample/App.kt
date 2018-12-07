package akka_sample

import akka.http.javadsl.server.HttpApp
import akka.http.javadsl.server.Route

object App : HttpApp() {
    override fun routes() : Route = route(
        path("hello", { get { complete("Hello from Akka HTTP!") } })
    )

    // to make it accessible from test?
    fun route() = routes()
}

fun main() {
    App.startServer("0.0.0.0", 8080)
}