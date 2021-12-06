class Database extends Warenkorb{
   private var storedItems:Array[StoreItem] = new Array[StoreItem](0)

  override def delete(id:Int): Array[StoreItem] = {
    var b :Boolean = false
    for (i <- storedItems){
      if (id==i.id) {
        storedItems = storedItems.filterNot(_ == i)
        i.logAction("delete", i.name)
        b=true
      }
    }
    if(!b){
      println("Id " + id + " nicht gefunden")
    }
    storedItems
  }

  override def search(name: String): Array[StoreItem] = {
    var withName:Array[StoreItem] = new Array[StoreItem](20)
    withName = storedItems.filter(_.name == name)
    for(i<-withName){
      i.logAction("Search", i.name)
    }
    if(withName.isEmpty){
      println(name + " nicht gefunden")
    }
    withName
  }

  override def sortByValueAsc(): Array[StoreItem] = {
    val sortAuf :Array[StoreItem] = storedItems.sortBy(_.value)
    sortAuf
  }

  override def sortByValueDesc(): Array[StoreItem] = {
    val sortAb :Array[StoreItem] =this.sortByValueAsc().reverse
    sortAb
  }

  override def store(item: StoreItem): Array[StoreItem] = {
    storedItems :+= item
    item.logAction("Store", item.name)
    storedItems
  }

  override def sumUp(): Int = {
    var total = 0;
    for(i<-storedItems){
      total += i.value
  }
    println(total)
    total
  }
}
