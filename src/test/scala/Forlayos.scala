import io.gatling.core.scenario.Simulation

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class Forlayos  extends Simulation{

  val scenarioName = "Forlayos"
  val httpProtocol=http.baseURL("http://localhost:8080")

  val scn = scenario(scenarioName).exec(
    ForlayosTasks.getForlayos,
    ForlayosTasks.postForlayo,
    ForlayosTasks.getForlayo,
    ForlayosTasks.putForlayo,
    ForlayosTasks.deleteForlayo
  )

  setUp(scn.inject(rampUsers(10) over (10 seconds)))
    .protocols(httpProtocol)
}
