package code
package snippet

import scala.xml.{NodeSeq, Text}
import net.liftweb.util._
import net.liftweb.common._
import java.util.Date
import code.lib._
import Helpers._
import net.liftweb._
import sitemap._


case class UserName( userName: String )

object Profile{

  
  // Create a menu for http://localhost/username
  val userNameParam = Menu.param[UserName]("Post", "Post",
    s => Full(UserName(s)),
    un => un.userName
  ) / *
    //>> If(() => S.loggedIn_?, () => RedirectResponse("/login"))

  lazy val loc = userNameParam.toLoc

  def render = "*" #> loc.currentValue.map(_.userName)
  

}

class Profile( unParam: UserName ){

  def render = <div>param: {unParam.userName}</div>

}
