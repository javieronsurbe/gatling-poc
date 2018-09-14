import io.gatling.core.scenario.Simulation

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class Forlayos  extends Simulation{

  val scenarioName = "Forlayos"
  val httpProtocol=http.baseURL("http://localhost:8080/v1")

  val scn = scenario(scenarioName).exec(
    ProvisionTasks.getForlayos
  )

  setUp(scn.inject(rampUsers(10) over (10 seconds)))
    .protocols(httpProtocol)
}
