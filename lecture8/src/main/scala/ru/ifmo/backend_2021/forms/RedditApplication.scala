package ru.ifmo.backend_2021.forms

import ru.ifmo.backend_2021.ApplicationBootstrap
import scalatags.Text
import scalatags.Text.all._

object RedditApplication extends cask.MainRoutes {
  val serverUrl = s"http://$host:$port"
  val defaultMessages = List(
    Message("ventus976", "I don't particularly care which interaction they pick so long as it's consistent."),
    Message("XimbalaHu3", "Exactly, both is fine but do pick one.")
  )

  val defaultState = Messages(defaultMessages)

  @cask.get("/")
  def hello(
    state: String = defaultState,
    errorOpt: Option[String] = None,
    userName: Option[String] = None,
    msg: Option[String] = None
  ): Text.all.doctype = doctype("html")(
    html(
      head(link(rel := "stylesheet", href := ApplicationBootstrap.styles)),
      body(
        div(cls := "container")(
          h1("Reddit: Swain is mad :("),
          div(for (Message(name, msg) <- Messages.fromString(state)) yield p(b(name), " ", msg)),
          for (error <- errorOpt) yield i(color.red)(error),
          form(action := "/", method := "post")(
            input(
              `type` := "text",
              name := "name",
              placeholder := "User name",
              userName.map(value := _)
            ),
            input(
              `type` := "text",
              name := "msg",
              placeholder := "Write a message!",
              msg.map(value := _)
            ),
            input(
              `type` := "hidden",
              name := "state",
              value := state
            ),
            input(`type` := "submit", value := "test"),
            attr("state") := "test",
          )
        )
      )
    )
  )

  @cask.postForm("/")
  def postChatMsg(name: String, msg: String, state: String): Text.all.doctype = {
    log.debug(name, msg, state)
    if (name == "") hello(state, Some("Name cannot be empty"), Some(name), Some(msg))
    else if (msg == "") hello(state, Some("Message cannot be empty"), Some(name), Some(msg))
    else {
      hello(s"$state|$name#$msg", None, Some(name), None)
    }
  }

  log.debug(s"Starting at $serverUrl")
  initialize()
}
