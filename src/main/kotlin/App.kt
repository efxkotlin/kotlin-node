import com.efxcode.api.ProjectApi

external fun require(module:String): dynamic

fun main() {
    println("Fetch Project Details")
    val express = require("express")
    val app = express()
    ProjectApi(app)
}
