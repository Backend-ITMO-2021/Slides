package ru.ifmo.backend_2021.minimal

import ru.ifmo.backend_2021.ApplicationBootstrap
import scalatags.Text
import scalatags.Text.all._

object MinimalApplication2 extends cask.MainRoutes {
  @cask.get("/")
  def hello(): Text.all.doctype = doctype("html")(
    html(
      head(link(rel := "stylesheet", href := ApplicationBootstrap.styles)),
      body(
        div(cls := "container")(
          h1("Hello"),
          p("World")
        )
      )
    )
  )

  @cask.post("/do-thing")
  def doThing(request: cask.Request): String = {
    request.text().reverse
  }

  initialize()
}
