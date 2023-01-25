package basic

import org.scalatestplus.play.PlaySpec

class BasicScalaTest extends PlaySpec {

  "BasicScala" should {
    "compute email" in {
      BasicScala.isEmail("jean@particeep.com") mustBe true
      BasicScala.isEmail("jean_particeep.com") mustBe false
      BasicScala.power(5,5) mustBe 3125

      BasicScala.power(99,38997) mustBe 1723793299
      ComputeAverage.average(List(1, 10, 16)).get mustBe 9

      BasicScala.encodeParamsInUrl(Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")) mustBe "?sort_by=name&order_by=asc&user_id=12"
    }
  }
}
