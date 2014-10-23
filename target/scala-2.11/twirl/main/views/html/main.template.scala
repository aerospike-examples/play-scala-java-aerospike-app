
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
import helper._
/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*3.32*/("""

"""),format.raw/*5.1*/("""<!DOCTYPE html>

<html>
  <head>
    <title>"""),_display_(/*9.13*/title),format.raw/*9.18*/("""</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

    <link rel="stylesheet" media="screen" href=""""),_display_(/*16.50*/routes/*16.56*/.Assets.at("stylesheets/main.css")),format.raw/*16.90*/("""">
    <link rel="shortcut icon" href="http://www.aerospike.com/wp-content/uploads/2012/08/favicon.png" type="image/x-icon" />
    <script src=""""),_display_(/*18.19*/routes/*18.25*/.Assets.at("javascripts/main.js")),format.raw/*18.58*/("""" type="text/javascript"></script>
  </head>
  <body>
    <div class="text-center">
      <h2>Yet Another To-Do App</h2>
      <h6>But, this one is built using JASPS - Java Aerospike Play and Scala </h6>
    </div>
    <section class="main-content">
    	"""),_display_(/*26.7*/content),format.raw/*26.14*/("""
    """),format.raw/*27.5*/("""</section>
  </body>
</html>
"""))}
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Oct 23 13:04:33 PDT 2014
                  SOURCE: /Users/dash/Apps/play/play-scala-java-aerospike-app/app/views/main.scala.html
                  HASH: 48e7f470f1e0279d755b051c09057b6a9e48bb1b
                  MATRIX: 742->19|860->49|888->51|959->96|984->101|1361->451|1376->457|1431->491|1603->636|1618->642|1672->675|1954->931|1982->938|2014->943
                  LINES: 26->3|29->3|31->5|35->9|35->9|42->16|42->16|42->16|44->18|44->18|44->18|52->26|52->26|53->27
                  -- GENERATED --
              */
          