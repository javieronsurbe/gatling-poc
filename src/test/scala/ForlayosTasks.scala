import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

object ForlayosTasks {

  private def random= scala.util.Random
  private def randomString = random.alphanumeric.take(10).mkString
  private def randomInt = random.nextInt(100)

  private def create =
    s"""
       |{
       |"id": "$randomInt",
       |"name": "$randomString",
       |"number": $randomInt,
       |"price": $randomInt.0
       |}
     """.stripMargin


  val getForlayos = exec(
    http("GetForlayos")
      .get("/forlayos")
      .header("Content-Type", "application/json")
      .asJSON
      .check(status is 200)
  )
  val postForlayo= exec(
    http("PostForlayo")
      .post("/forlayos")
      .header("Content-Type", "application/json")
      .body(StringBody(create))
      .asJSON
      .check(jsonPath("$.id").saveAs("forlayoId"))
      .check(status is 201)
  )
  val getForlayo = exec(
    http("GetForlayo")
      .get("/forlayos/${forlayoId}")
      .header("Content-Type", "application/json")
      .asJSON
      .check(jsonPath("$.id"))
  )
  val putForlayo = exec(
    http("PutForlayo")
      .put("/forlayos/${forlayoId}")
      .body(StringBody(create))
      .asJSON
      .check(jsonPath("$.id"))
      .check(status is 200)
  )

  val deleteForlayo = exec(
    http("DeleteForlayo")
      .delete("/forlayos/${forlayoId}")
      .check(status is 202)
  )



}
