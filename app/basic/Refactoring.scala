package basic

/**
 * What is the complexity of the function ?
 * since the Immutable List are similar to the Java's the LinkedList,
 * means operations that occurs on Lists requires traversing all the elements of the List.
 * Hence, the complexity in this case is linear to the number of list elements.
 *  O(n)
 *
 * Refactor it to be a better function

 */
object Refactoring {

  case class File(
                   name:     String,
                   category: String
                 )


  def getCategoriesRefactored(files: List[File]): List[String] = {
    files.filter(d=> d.category.nonEmpty).map(_.category).distinct
  }

  def getCategories(files: List[File]): List[String] = {
    val categories: List[String] = List()
    if(files != null) {
      for(file <- files) { // O(n) the for loop will be executed n times (n = file size)
        if(file.category != null && !categories.contains(file.category)) {
          categories :+ file.category // The elements of the List O(n)
        }
      }
    }
    return categories
  }


}
