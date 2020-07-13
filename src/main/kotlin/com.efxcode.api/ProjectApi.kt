package com.efxcode.api

import com.efxcode.domain.Project
import com.efxcode.domain.Team
import kotlin.js.Date

class ProjectApi constructor(private val app: dynamic) {

    private val projectList = mutableListOf<Project>()

    init {
        loadProject()
        listen()
        projects()
        project()
    }

    private fun project() {
        app.get("/projects/:projectId") {
            req,res -> res.send(getProject(req.params.projectId as String))
        }
    }

    private fun getProject(projectId: String):Project? {
        return projectList.find {it.id == projectId}
    }

    private fun projects() {
        app.get("/projects") { _, res ->
            res.send(projectList)
        }
    }

    private fun listen() {
        app.listen(3000) {
            println("Listening on Port 3000")
        }
    }

    private fun loadProject() {
        val members = listOf("Jack", "Walsh", "Andrew")
        val team1 = Team("MacDonald", members)
        projectList += Project("EV1A","Event Updater", team1, Date(2020, 1, 1), Date(2020, 8, 1))
    }
}