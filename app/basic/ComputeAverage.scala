package basic

/**
 * Compute the average of the list
 *
 * ex : [1, 10, 16] -> 9
 */
object ComputeAverage {

  def average(l: List[Double]) : Option[Double] = if (l.nonEmpty) Some(l.sum / l.size) else  None

}
