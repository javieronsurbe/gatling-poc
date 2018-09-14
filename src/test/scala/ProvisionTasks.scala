import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

object ProvisionTasks {

  val getForlayos = exec(
    http("GetForlayos")
      .get("/forlayos")
      .header("Content-Type", "application/json")
      .asJSON
      .check(jsonPath("$..Id").findAll.saveAs("forlayoId"))
  )
//  val getForlayo = exec(
//    http("GetForlayo")
//      .get(s"/forlayos/${forlayoId}")
//      .header("Content-Type", "application/json")
//      .asJSON
//      .check(jsonPath("$..Id"))
//  )

}
