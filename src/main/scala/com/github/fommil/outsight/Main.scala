package com.github.fommil.outsight

import java.awt.GraphicsEnvironment
import akka.contrib.jul.JavaLogging

object Main extends App with JavaLogging {

  val rules = SnowWhiteRules()
  val story = Story(Set(EmotivHistExtractor(rules)), rules)

  val view = new StoryView(story, finished)
  GraphicsEnvironment.getLocalGraphicsEnvironment.getDefaultScreenDevice.setFullScreenWindow(view)

  def finished(journey: Journey, scene: Scene) {
    val latest = (scene, Set[Response]()) // dummy
    view.update(journey.copy(scenes = journey.scenes :+ latest))
  }

  //  val emotiv = new Emotiv()
  //  import scala.collection.JavaConversions._
  //  val session = new EmotivSession()
  //  session.setName("My Session")
  //  for (packet <- emotiv) {
  //    val datum = EmotivDatum.fromPacket(packet)
  //    datum.setSession(session)
  //    log.info(datum.toString)
  //  }

}