// @SOURCE:/Users/dash/Apps/play/play-scala-java-aerospike-app/conf/routes
// @HASH:0132c2f455b28e4547d7e7d159d9c4031918a4b7
// @DATE:Tue Oct 21 12:20:58 PDT 2014


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_Application_index0_invoker = createInvoker(
controllers.Application.index(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
        

// @LINE:9
private[this] lazy val controllers_Assets_at1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at1_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:10
private[this] lazy val controllers_Application_createTodo2_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("createTodo"))))
private[this] lazy val controllers_Application_createTodo2_invoker = createInvoker(
controllers.Application.createTodo(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "createTodo", Nil,"POST", """""", Routes.prefix + """createTodo"""))
        

// @LINE:11
private[this] lazy val controllers_Application_deleteTodo3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteTodo"))))
private[this] lazy val controllers_Application_deleteTodo3_invoker = createInvoker(
controllers.Application.deleteTodo(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "deleteTodo", Nil,"POST", """""", Routes.prefix + """deleteTodo"""))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """createTodo""","""controllers.Application.createTodo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteTodo""","""controllers.Application.deleteTodo()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0_route(params) => {
   call { 
        controllers_Application_index0_invoker.call(controllers.Application.index())
   }
}
        

// @LINE:9
case controllers_Assets_at1_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at1_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:10
case controllers_Application_createTodo2_route(params) => {
   call { 
        controllers_Application_createTodo2_invoker.call(controllers.Application.createTodo())
   }
}
        

// @LINE:11
case controllers_Application_deleteTodo3_route(params) => {
   call { 
        controllers_Application_deleteTodo3_invoker.call(controllers.Application.deleteTodo())
   }
}
        
}

}
     