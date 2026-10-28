// COMP2850 Portfolio: Week 4
// ToDoList class

import kotlinx.datetime.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.forEachLine
import kotlin.io.path.writer
import kotlin.io.path.readLines

class ToDoList() {
    private val items = mutableListOf<ToDoItem>()

    val size get() = items.size
    val notStarted: Int
        get() {
            var count = 0
            for (item in items) {
                if (item.status == ItemStatus.NotStarted) {
                    count += 1
                }
            }
            return count
        }

    val inProgress: Int
     get() {
            var count = 0
            for (item in items) {
                if (item.status == ItemStatus.InProgress) {
                    count += 1
                }
            }
            return count
        }

    val done: Int
        get() {
            var count = 0
            for (item in items) {
                if (item.status == ItemStatus.Done) {
                    count += 1
                }
            }
            return count
        }

    val overdue: Int
        get() {
            var count = 0
            for (item in items) {
                if (item.isOverdue()) {
                    count += 1
                }
            }
            return count
        }

    constructor(filename: String): this() {
        load(filename)
    }

    fun load(filename: String) {
    
        items.clear()

        //reads lines into array lines
        
        var lines = Path(filename).readLines()
        

        //iterates through each line in the array lines
        for (line in lines){
            if (line.isNotEmpty()){
                val parts = line.split(": ", limit=3) // grabs each part of line and puts it into parts
                val Date = LocalDate.parse(parts[0])
                val Status = ItemStatus.valueOf(parts[1])
                val Description = parts[2]
                items.add(ToDoItem(Date,Status,Description))
            }        
        }


        // See data/to-do.csv for an example of the format
    }

    fun save(filename: String) {
        Path(filename).writer().use {
            for (item in items) {
                it.write("$item\n")
            }
        }
    }

    fun add(vararg item: ToDoItem) = item.forEach { items.add(it) }

    fun deleteDone(): Boolean {
        var flag = false
        for (item in items.toList()){
            if (item.status == ItemStatus.Done){
                items.remove(item)
                flag = true
            }
        }
        return flag
    }

    fun getItems(status: ItemStatus? = null): List<ToDoItem> {
        // Write code here to return a list of items with the matching
        // status, or a list of all items if status argument is null
        if (status == null){
            return items
        }

        val items_matchingstatus = mutableListOf<ToDoItem>()

        for (item in items.toList()){
            if (item.status == status){
                items_matchingstatus.add(item)
            }
        }

        return items_matchingstatus
    }

fun getItemsDueOn(date: LocalDate): List<ToDoItem> {
        val items_matching_due_date = mutableListOf<ToDoItem>()

        for (item in items.toList()) {
            if (item.dueDate == date) { 
                items_matching_due_date.add(item)
            }
        } 

        return items_matching_due_date
    }
}
