package jp.mwsoft.sobacha.corpusio

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.Spec
import scala.collection.JavaConversions._
import org.scalatest.FunSpec

@RunWith( classOf[JUnitRunner] )
class WakatiCorpusIOTest extends FunSpec with ShouldMatchers {

  val io = new WakatiCorpusIO()

  describe( "「もう寝る。」の解析" ) {
    val list = io.readSentence( "もう 寝る 。" )
    it( "size 3" ) { list should have length 3 }
    it( "surfaceの確認" ) {
      list.map( _.getSurface() ).toList should be( List( "もう", "寝る", "。" ) )
    }
    it( "Tagの確認" ) {
      list.map( _.getTags().size() ) should be( List( 0, 0, 0 ) )
    }
  }

  describe( "空行の解析" ) {
    val list = io.readSentence( "" )
    it( "size 0" ) { list should have length 0 }
  }
}