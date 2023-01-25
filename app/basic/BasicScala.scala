package basic

/**
 * This is basic language questions so don't use external library or build in function
 */
object BasicScala {

  /**
   * Encode parameter in url format
   *
   * Example:
   *
   * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
   * output : "?sort_by=name & order_by=asc & user_id=12"
   * ? + (key1=value1) & (key2=value2) & (key3=value3)
   *
   * input  : Map()
   * output : ""
   */
  def encodeParamsInUrl(params: Map[String, String]): String = {
    val firstCode: String = "?"
    val secondCode: String = "="
    val thirdCode: String = "&"

    if (params.nonEmpty) {
      val i = params map { t: (String, String) => t._1 + secondCode + t._2 }
      firstCode + i.mkString(thirdCode)
    }
    else ""
  }

  /**
   * Test if a String is an email
   */
  def isEmail(maybeEmail: String): Boolean = if ("""(?=[^\s]+)(?=(\w+)@([\w\.]+))""".r.findFirstIn(maybeEmail).isEmpty) false else true

  /**
   * Compute i ^ n
   *
   * Example:
   *
   * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
   * output : 8
   *
   * input : (i = 99, n = 38997)
   * output : 1723793299
   */
  def power(i: Int, n: Int): Int = {
    if (n == 0) {
      1
    }
    else {
      var pow = 1
      for (_ <- 1 to n) {
        pow = pow * i
      }
      pow
    }
  }


}