// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/abbasi/Desktop/megaklinic/webservicedemo/conf/routes
// @DATE:Sat Jul 07 01:24:08 EEST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
