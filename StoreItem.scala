class StoreItem (var id: Int, var name: String, var value: Int) extends Logger with Artikel  {

  override def logAction(actionName: String, name: String): Unit = {
    val action = actionName match {
      case "delete" => " gelöscht"
      case "Search" => " gefunden"
      case "Store" => " gespeichert"
    }
    println(name + action)
  }
}
