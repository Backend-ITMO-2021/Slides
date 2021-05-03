package ru.ifmo.backend_2021.forms

import ru.ifmo.backend_2021.ApplicationBootstrap
import scalatags.Text
import scalatags.Text.all._

import scala.util.Try

case class Message(username: String, message: String) {
  def toState: String = s"$username#$message"
}

object Message {
  def apply(fromString: String): Message = {
    val List(username, message) = fromString.split("#").toList
    Message(username, message)
  }
}

object Messages {
  def apply(messages: List[Message]): String =
    messages.map(_.toState).mkString("|")

  def fromString(string: String): List[Message] =
    Try {
      string.split("\\|").map(Message(_)).toList
    }.toOption.getOrElse(Nil)

}

object RedditApplicationSimple extends cask.MainRoutes {
  val serverUrl = s"http://$host:$port"
  val defaultMessages = List(
    Message("ventus976", "I don't particularly care which interaction they pick so long as it's consistent."),
    Message("XimbalaHu3", "Exactly, both is fine but do pick one.")
  )

  val defaultState = Messages(defaultMessages)

  @cask.get("/")
  def hello(
    state: String = defaultState
  ): Text.all.doctype = doctype("html")(
    html(
      head(link(rel := "stylesheet", href := ApplicationBootstrap.styles)),
      body(
        div(cls := "container")(
          h1("Reddit: Swain is mad :("),
          div(for (Message(name, msg) <- Messages.fromString(state)) yield p(b(name), " ", msg)),
          form(action := "/", method := "post")(
            input(
              `type` := "text",
              name := "name",
              placeholder := "User name",
            ),
            input(
              `type` := "text",
              name := "msg",
              placeholder := "Write a message!",
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
    hello(s"$state|$name#$msg")
  }

  log.debug(s"Starting at $serverUrl")
  initialize()
}
