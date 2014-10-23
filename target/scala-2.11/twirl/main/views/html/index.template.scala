
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

/**/
object index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template3[Boolean,String,Map[String, String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(connected: Boolean)(status: String)(todos: Map[String, String]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.66*/("""

"""),_display_(/*3.2*/main("JASPS")/*3.15*/ {_display_(Seq[Any](format.raw/*3.17*/("""

	"""),format.raw/*5.2*/("""<div class="container">

		"""),_display_(/*7.4*/if(connected)/*7.17*/ {_display_(Seq[Any](format.raw/*7.19*/("""

		  """),format.raw/*9.5*/("""<div>
		    <!-- input -->
		    """),_display_(/*11.8*/helper/*11.14*/.form( action = routes.Application.createTodo() )/*11.63*/ {_display_(Seq[Any](format.raw/*11.65*/("""
		      """),format.raw/*12.9*/("""<div class="row">
		        <div class="input-group">
		          <input type="text" placeholder="What do you want To-Do?" class="form-control" name="todo">
		          <span class="input-group-btn">
		            <input type="submit" class="btn btn-primary" value="Add">
		          </span>
		        </div>
		        <div class="form-group has-error text-center">
		          <p class="help-block"></p>
		        </div>
		      </div>
		    """)))}),format.raw/*23.8*/("""
		  """),format.raw/*24.5*/("""</div>

		  <h3>Your To-Dos</h3>

		  <div>
		  	"""),_display_(/*29.7*/if(todos.size > 0)/*29.25*/	{_display_(Seq[Any](format.raw/*29.27*/("""
					"""),_display_(/*30.7*/for((k, v) <- todos) yield /*30.27*/ {_display_(Seq[Any](format.raw/*30.29*/("""
		        """),_display_(/*31.12*/helper/*31.18*/.form( action = routes.Application.deleteTodo() )/*31.67*/ {_display_(Seq[Any](format.raw/*31.69*/("""
					    """),format.raw/*32.10*/("""<p class="input-group">
					      <input type="text" class="form-control" disabled=disabled value=""""),_display_(/*33.78*/v),format.raw/*33.79*/("""">
					      <span class="input-group-btn">
				        	<input type="hidden" name="todoKey" value=""""),_display_(/*35.58*/k),format.raw/*35.59*/("""">
				        	<button class="btn btn-danger" aria-label="Remove">X</button>
					      </span>
					    </p>
	        	""")))}),format.raw/*39.12*/("""
					""")))}),format.raw/*40.7*/("""
		  	""")))}/*41.8*/else/*41.13*/{_display_(Seq[Any](format.raw/*41.14*/("""
		  		"""),format.raw/*42.7*/("""<p class="text-muted">None &mdash; seems like you're all caught up!</p>
		  	""")))}),format.raw/*43.7*/("""
		  """),format.raw/*44.5*/("""</div>

		""")))}/*46.5*/else/*46.10*/{_display_(Seq[Any](format.raw/*46.11*/("""

			"""),format.raw/*48.4*/("""<div class="text-center">
			  <h3>Oops!</h3>
			  <h4>"""),_display_(/*50.11*/status),format.raw/*50.17*/("""</h4>
		  </div>

		""")))}),format.raw/*53.4*/("""

	"""),format.raw/*55.2*/("""</div>

""")))}),format.raw/*57.2*/("""
"""))}
  }

  def render(connected:Boolean,status:String,todos:Map[String, String]): play.twirl.api.HtmlFormat.Appendable = apply(connected)(status)(todos)

  def f:((Boolean) => (String) => (Map[String, String]) => play.twirl.api.HtmlFormat.Appendable) = (connected) => (status) => (todos) => apply(connected)(status)(todos)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Thu Oct 23 13:30:32 PDT 2014
                  SOURCE: /Users/dash/Apps/play/play-scala-java-aerospike-app/app/views/index.scala.html
                  HASH: 90cd884412bfab08e3c9dedbbcb2575836422439
                  MATRIX: 751->1|903->65|931->68|952->81|991->83|1020->86|1073->114|1094->127|1133->129|1165->135|1225->169|1240->175|1298->224|1338->226|1374->235|1848->679|1880->684|1956->734|1983->752|2023->754|2056->761|2092->781|2132->783|2171->795|2186->801|2244->850|2284->852|2322->862|2450->963|2472->964|2601->1066|2623->1067|2776->1189|2813->1196|2838->1204|2851->1209|2890->1210|2924->1217|3032->1295|3064->1300|3093->1312|3106->1317|3145->1318|3177->1323|3260->1379|3287->1385|3338->1406|3368->1409|3407->1418
                  LINES: 26->1|29->1|31->3|31->3|31->3|33->5|35->7|35->7|35->7|37->9|39->11|39->11|39->11|39->11|40->12|51->23|52->24|57->29|57->29|57->29|58->30|58->30|58->30|59->31|59->31|59->31|59->31|60->32|61->33|61->33|63->35|63->35|67->39|68->40|69->41|69->41|69->41|70->42|71->43|72->44|74->46|74->46|74->46|76->48|78->50|78->50|81->53|83->55|85->57
                  -- GENERATED --
              */
          